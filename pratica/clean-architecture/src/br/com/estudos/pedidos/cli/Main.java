package br.com.estudos.pedidos.cli;

import br.com.estudos.pedidos.application.GerenciarPedidos;
import br.com.estudos.pedidos.domain.Pedido;
import br.com.estudos.pedidos.infrastructure.PedidoRepositoryEmMemoria;

public final class Main {
    public static void main(String[] args) {
        var repository = new PedidoRepositoryEmMemoria();
        var useCase = new GerenciarPedidos(repository);
        Pedido criado = useCase.criar(args.length == 0 ? "Pedido de estudo" : args[0]);
        System.out.println("Criado: " + criado.status() + " - " + criado.titulo());
        Pedido confirmado = useCase.confirmar(criado.id());
        System.out.println("Confirmado: " + confirmado.status());
        System.out.println("Consultado: " + useCase.buscar(criado.id()).status());
    }
}
