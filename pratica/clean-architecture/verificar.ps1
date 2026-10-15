$ErrorActionPreference = 'Stop'
$taskPracticeRoot = $PSScriptRoot
$taskOutput = Join-Path $taskPracticeRoot 'out'
New-Item -ItemType Directory -Path $taskOutput -Force | Out-Null
$taskSources = @(Get-ChildItem (Join-Path $taskPracticeRoot 'src') -Recurse -Filter '*.java' | ForEach-Object FullName)
$taskCore = @($taskSources | Where-Object { $_ -notmatch '[\\/](infrastructure|cli)[\\/]' })
$taskTests = @(Get-ChildItem (Join-Path $taskPracticeRoot 'tests') -Recurse -Filter '*.java' | ForEach-Object FullName)

& javac --release 17 -encoding UTF-8 -d (Join-Path $taskOutput 'core') @taskCore
if ($LASTEXITCODE -ne 0) { throw 'Falha ao compilar o nucleo isoladamente' }
& javac --release 17 -encoding UTF-8 -d (Join-Path $taskOutput 'app') @taskSources
if ($LASTEXITCODE -ne 0) { throw 'Falha ao compilar a aplicacao' }
& javac --release 17 -encoding UTF-8 -cp (Join-Path $taskOutput 'app') -d (Join-Path $taskOutput 'tests') @taskTests
if ($LASTEXITCODE -ne 0) { throw 'Falha ao compilar testes' }
$taskClasspath = (Join-Path $taskOutput 'app') + [IO.Path]::PathSeparator + (Join-Path $taskOutput 'tests')
& java -cp $taskClasspath br.com.estudos.pedidos.PedidosTest
if ($LASTEXITCODE -ne 0) { throw 'Falha nos testes' }
& java -cp (Join-Path $taskOutput 'app') br.com.estudos.pedidos.cli.Main
if ($LASTEXITCODE -ne 0) { throw 'Falha na demonstracao' }
