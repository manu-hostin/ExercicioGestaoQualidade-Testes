<h1>🛠️ Sistema de Gestão de Qualidade e Manutenção Industrial</h1>

<h2>Visão Geral</h2>
<p>
  Este projeto implementa um sistema completo para gestão de equipamentos, registro de falhas, ações corretivas e geração de relatórios industriais.
  O foco é garantir rastreabilidade, confiabilidade operacional e suporte às rotinas de manutenção corretiva e preventiva.
</p>
<p>O sistema é dividido em quatro serviços principais:</p>

<ul>
  <li>EquipamentoService</li>
  <li>FalhaService</li>
  <li>AcaoCorretivaService</li>
  <li>RelatorioService</li>
</ul>

<hr/>

<h1>1. EquipamentoService</h1>
<p>Serviço responsável pelo CRUD básico de equipamentos.</p>

<h2>1.1 criarEquipamento(Equipamento equipamento)</h2>
<ul>
  <li><b>Parâmetros:</b> Equipamento equipamento</li>
  <li><b>Retorno:</b> Equipamento</li>
  <li><b>Lógica:</b> Salvar um novo equipamento sempre com status <b>OPERACIONAL</b>.</li>
</ul>

<h2>1.2 buscarEquipamentoPorId(long id)</h2>
<ul>
  <li><b>Parâmetros:</b> long id</li>
  <li><b>Retorno:</b> Equipamento</li>
  <li><b>Lógica:</b>
    <ul>
      <li>Validar se o equipamento existe.</li>
      <li>Se não existir → lançar <code>RuntimeException("Equipamento não encontrado!")</code>.</li>
      <li>Se existir → retornar o equipamento completo.</li>
    </ul>
  </li>
</ul>

<hr/>

<h1>2. FalhaService</h1>
<p>Serviço crítico do sistema, responsável por registrar falhas e suas consequências imediatas.</p>

<h2>2.1 registrarNovaFalha(Falha falha)</h2>
<ul>
  <li><b>Parâmetros:</b> Falha falha</li>
  <li><b>Retorno:</b> Falha</li>
  <li><b>Lógica (Transacional):</b>
    <ul>
      <li>Validar se o equipamento informado existe.</li>
      <li>Se não existir → lançar <code>IllegalArgumentException("Equipamento não encontrado!")</code>.</li>
      <li>Salvar a falha com status <b>ABERTA</b>.</li>
      <li><b>Regra de Negócio:</b>
        <ul>
          <li>Se a falha for <b>CRÍTICA</b>, atualizar o equipamento para status <b>EM_MANUTENCAO</b>.</li>
        </ul>
      </li>
    </ul>
  </li>
</ul>

<h2>2.2 buscarFalhasCriticasAbertas()</h2>
<ul>
  <li><b>Parâmetros:</b> nenhum</li>
  <li><b>Retorno:</b> Lista de Falha</li>
  <li><b>Lógica:</b>
    <ul>
      <li>Buscar falhas com status <b>ABERTA</b> e criticidade <b>CRITICA</b>.</li>
      <li>Retornar a lista filtrada.</li>
    </ul>
  </li>
</ul>

<hr/>

<h1>3. AcaoCorretivaService</h1>

<h2>3.1 registrarConclusaoDeAcao(AcaoCorretiva acao)</h2>
<ul>
  <li><b>Parâmetros:</b> AcaoCorretiva acao</li>
  <li><b>Retorno:</b> AcaoCorretiva</li>
  <li><b>Lógica:</b>
    <ul>
      <li>Validar se o <code>falhaId</code> existe.</li>
      <li>Se não existir → lançar <code>RuntimeException</code>.</li>
      <li>Salvar a ação corretiva.</li>
      <li><b>Regra de Negócio 1:</b> Atualizar a falha para status <b>RESOLVIDA</b>.</li>
      <li><b>Regra de Negócio 2:</b> Se a falha era <b>CRITICA</b>, atualizar o equipamento para <b>OPERACIONAL</b>.</li>
    </ul>
  </li>
</ul>

<hr/>

<h1>4. RelatorioService</h1>

<h2>4.1 gerarRelatorioTempoParada()</h2>
<ul>
  <li><b>Parâmetros:</b> nenhum</li>
  <li><b>Retorno:</b> Lista de RelatorioParadaDTO</li>
</ul>

<h2>4.2 buscarEquipamentosSemFalhasPorPeriodo(LocalDate dataInicio, LocalDate dataFim)</h2>
<ul>
  <li><b>Parâmetros:</b> dataInicio, dataFim</li>
  <li><b>Retorno:</b> Lista de Equipamento</li>
  <li><b>Lógica:</b> Buscar equipamentos que <b>não tiveram falhas</b> no período informado.</li>
</ul>

<h2>4.3 buscarDetalhesCompletosFalha(long falhaId)</h2>
<ul>
  <li><b>Parâmetros:</b> long falhaId</li>
  <li><b>Retorno:</b> FalhaDetalhadaDTO</li>
  <li><b>Lógica:</b> Validar se o ID da falha existe; se não existir → lançar <code>RuntimeException</code>.</li>
</ul>

<h2>4.4 gerarRelatorioManutencaoPreventiva(int contagemMinimaFalhas)</h2>
<ul>
  <li><b>Parâmetros:</b> contagemMinimaFalhas</li>
  <li><b>Retorno:</b> Lista de EquipamentoContagemFalhasDTO</li>
  <li><b>Lógica:</b>
    <ul>
      <li>Validar se o valor informado é maior que zero.</li>
      <li>Se for ≤ 0 → lançar <code>RuntimeException</code>.</li>
      <li>Buscar equipamentos que possuam falhas <b>maior ou igual</b> ao valor informado.</li>
    </ul>
  </li>
</ul>

<hr/>

<h1>Tabelas do Banco de Dados</h1>

<h2>Equipamento</h2>
<p>Armazena ativos industriais com restrições para status válido.</p>

<h2>Falha</h2>
<p>Registra falhas com criticidade, status e vínculo obrigatório ao equipamento.</p>

<h2>AcaoCorretiva</h2>
<p>Registra ações tomadas para resolver falhas, mantendo integridade referencial.</p>
