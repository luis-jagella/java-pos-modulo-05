# Exemplo de análise de riscos

Caso didático: aplicação de pedidos inicialmente modular. Os valores abaixo são estimativas do exercício, não medições de produção. Escala ordinal de 1 a 3; produto serve apenas como apoio à priorização.

| Risco | Probabilidade | Impacto | Escore | Mitigação e responsável no exercício | Evidência de revisão |
| --- | --- | --- | --- | --- | --- |
| Importar infraestrutura no domínio | 2 | 2 | 4 | Autor: compilar núcleo separado e revisar imports | Novo adaptador ou dependência |
| Perder dados ao reiniciar | 3 | 3 | 9 | Autor: documentar memória volátil; adicionar persistência antes de uso real | Requisito de armazenamento durável |
| Reprocessamento duplicar pedido | 2 | 3 | 6 | Autor: definir identidade/idempotência antes de integrar mensagens | Inclusão de Kafka ou retries |
| Ação inválida alterar estado | 2 | 2 | 4 | Autor: modelar transições e testar estado terminal | Nova transição |
| Broker ou serviço indisponível | 2 | 3 | 6 | Exercício futuro: timeout, retry limitado e observabilidade | Implantação distribuída |

Não há broker na prática atual: a última linha é um risco prospectivo. O adaptador de memória não se destina a dados reais.

## Risk Storming

Revisar o [diagrama](catalogo-estilos.md) individualmente; anotar riscos por componente; comparar percepções; ajustar impacto e probabilidade; atribuir responsáveis e ações.

Um risco médio não implica deslocar toda a equipe para mitigação urgente. Deve ser acompanhado e priorizado conforme contexto e tendência.
