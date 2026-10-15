package br.com.estudos.pedidos.application;

import br.com.estudos.pedidos.domain.Pedido;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository {
    void salvar(Pedido pedido);
    Optional<Pedido> buscar(UUID id);
}
