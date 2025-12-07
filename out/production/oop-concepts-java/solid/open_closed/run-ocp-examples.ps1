# Szybkie uruchomienie przykładów Open/Closed Principle
# Użycie: .\run-ocp-examples.ps1

$ErrorActionPreference = "Stop"

Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Open/Closed Principle - Przykłady" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""

# Przejdź do katalogu src (dwa poziomy wyżej)
$scriptDir = Split-Path -Parent $PSScriptRoot
$srcPath = Split-Path -Parent $scriptDir
Set-Location $srcPath

# Kompilacja
Write-Host "[1/4] Kompilacja wersji 'before'..." -ForegroundColor Gray
javac solid/open_closed/before/*.java

Write-Host "[2/4] Kompilacja wersji 'after'..." -ForegroundColor Gray
javac solid/open_closed/after/*.java

Write-Host ""
Write-Host "============================================" -ForegroundColor Red
Write-Host "  BEFORE - Naruszenie OCP" -ForegroundColor Red
Write-Host "============================================" -ForegroundColor Red
Write-Host ""

# Uruchomienie before
Write-Host "[3/4] Uruchomienie before/AreaCalculatorDemo..." -ForegroundColor Gray
java solid.open_closed.before.AreaCalculatorDemo

Write-Host ""
Write-Host "============================================" -ForegroundColor Green
Write-Host "  AFTER - Zgodnie z OCP" -ForegroundColor Green
Write-Host "============================================" -ForegroundColor Green
Write-Host ""

# Uruchomienie after
Write-Host "[4/4] Uruchomienie after/ShapeDemo..." -ForegroundColor Gray
java solid.open_closed.after.ShapeDemo

Write-Host ""
Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Gotowe!" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Porównanie:" -ForegroundColor Yellow
Write-Host "  BEFORE: Dodanie Triangle wymaga modyfikacji AreaCalculator" -ForegroundColor Red
Write-Host "  AFTER:  Triangle dodany bez modyfikacji istniejących klas" -ForegroundColor Green
Write-Host ""

