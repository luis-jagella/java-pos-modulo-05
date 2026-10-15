package br.com.estudos.pedidos.domain;

import java.util.Objects;
import java.util.UUID;

public record Pedido(UUID id, String titulo, StatusPedido status) {
    public Pedido {
        Objects.requireNonNull(id, "id obrigatorio");
        Objects.requireNonNull(status, "status obrigatorio");
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("titulo obrigatorio");
        }
        titulo = titulo.strip();
    }

    public static Pedido criar(String titulo) {
        return new Pedido(UUID.randomUUID(), titulo, StatusPedido.RASCUNHO);
    }

    public Pedido confirmar() {
        exigirRascunho();
        return new Pedido(id, titulo, StatusPedido.CONFIRMADO);
    }

    public Pedido cancelar() {
        exigirRascunho();
        return new Pedido(id, titulo, StatusPedido.CANCELADO);
    }

    private void exigirRascunho() {
        if (status != StatusPedido.RASCUNHO) {
            throw new IllegalStateException("pedido finalizado nao pode mudar de estado");
        }
    }
}
