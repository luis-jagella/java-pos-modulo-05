package br.com.estudos.pedidos.application;

import br.com.estudos.pedidos.domain.Pedido;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

public final class GerenciarPedidos {
    private final PedidoRepository repository;

    public GerenciarPedidos(PedidoRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    public Pedido criar(String titulo) {
        Pedido pedido = Pedido.criar(titulo);
        repository.salvar(pedido);
        return pedido;
    }

    public Pedido confirmar(UUID id) {
        Pedido confirmado = buscar(id).confirmar();
        repository.salvar(confirmado);
        return confirmado;
    }

    public Pedido cancelar(UUID id) {
        Pedido cancelado = buscar(id).cancelar();
        repository.salvar(cancelado);
        return cancelado;
    }

    public Pedido buscar(UUID id) {
        Objects.requireNonNull(id, "id obrigatorio");
        return repository.buscar(id)
                .orElseThrow(() -> new NoSuchElementException("pedido inexistente"));
    }
}
