package br.com.estudos.pedidos.infrastructure;

import br.com.estudos.pedidos.application.PedidoRepository;
import br.com.estudos.pedidos.domain.Pedido;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/** Adaptador didatico para uso sequencial; os dados nao sobrevivem ao processo. */
public final class PedidoRepositoryEmMemoria implements PedidoRepository {
    private final Map<UUID, Pedido> pedidos = new HashMap<>();

    @Override
    public void salvar(Pedido pedido) {
        pedidos.put(pedido.id(), pedido);
    }

    @Override
    public Optional<Pedido> buscar(UUID id) {
        return Optional.ofNullable(pedidos.get(id));
    }
}
