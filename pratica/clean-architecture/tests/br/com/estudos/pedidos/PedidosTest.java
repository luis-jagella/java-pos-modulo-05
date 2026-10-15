package br.com.estudos.pedidos;

import br.com.estudos.pedidos.application.GerenciarPedidos;
import br.com.estudos.pedidos.application.PedidoRepository;
import br.com.estudos.pedidos.domain.Pedido;
import br.com.estudos.pedidos.domain.StatusPedido;
import br.com.estudos.pedidos.infrastructure.PedidoRepositoryEmMemoria;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public final class PedidosTest {
    public static void main(String[] args) {
        var memoria = new PedidoRepositoryEmMemoria();
        var useCase = new GerenciarPedidos(memoria);
        var pedido = useCase.criar("  Aula 13  ");
        check(pedido.titulo().equals("Aula 13"), "normalizacao do titulo");
        check(useCase.buscar(pedido.id()).status() == StatusPedido.RASCUNHO, "criacao persistida");
        var confirmado = useCase.confirmar(pedido.id());
        check(confirmado.status() == StatusPedido.CONFIRMADO, "confirmacao");
        check(pedido.status() == StatusPedido.RASCUNHO, "entidade imutavel");
        expect(IllegalStateException.class, () -> useCase.cancelar(pedido.id()));
        check(useCase.buscar(pedido.id()).status() == StatusPedido.CONFIRMADO, "falha preserva estado");
        expect(IllegalStateException.class, () -> useCase.confirmar(pedido.id()));

        var outro = useCase.criar("Cancelamento");
        useCase.cancelar(outro.id());
        check(useCase.buscar(outro.id()).status() == StatusPedido.CANCELADO, "cancelamento persistido");
        expect(IllegalStateException.class, () -> useCase.confirmar(outro.id()));
        expect(NoSuchElementException.class, () -> useCase.buscar(UUID.randomUUID()));

        var spy = new RepositorySpy();
        var independente = new GerenciarPedidos(spy);
        expect(IllegalArgumentException.class, () -> independente.criar("   "));
        expect(IllegalArgumentException.class, () -> independente.criar(null));
        check(spy.gravacoes == 0, "entrada invalida nao grava");
        var valido = independente.criar("Outro adaptador");
        check(independente.buscar(valido.id()).equals(valido), "caso de uso depende apenas da porta");
        expect(NoSuchElementException.class, () -> independente.confirmar(UUID.randomUUID()));
        check(spy.gravacoes == 1, "pedido inexistente nao grava");
        System.out.println("OK: criacao, validacao, transicoes, isolamento e portas");
    }

    private static void check(boolean value, String message) {
        if (!value) throw new AssertionError(message);
    }

    private static void expect(Class<? extends RuntimeException> expected, Runnable action) {
        try {
            action.run();
        } catch (RuntimeException error) {
            if (expected.isInstance(error)) return;
            throw new AssertionError("excecao inesperada", error);
        }
        throw new AssertionError("excecao esperada: " + expected.getSimpleName());
    }

    private static final class RepositorySpy implements PedidoRepository {
        private Pedido ultimo;
        private int gravacoes;

        public void salvar(Pedido pedido) {
            ultimo = pedido;
            gravacoes++;
        }

        public Optional<Pedido> buscar(UUID id) {
            return ultimo != null && ultimo.id().equals(id) ? Optional.of(ultimo) : Optional.empty();
        }
    }
}
