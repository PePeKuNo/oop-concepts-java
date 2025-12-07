# Szybkie uruchomienie przykladow Liskov Substitution Principle
# Uzycie: Uruchom z katalogu 03_ADVANCED\src

$ErrorActionPreference = "Stop"

Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Liskov Substitution - Przyklady" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""

# Kompilacja
Write-Host "[1/4] Kompilacja wersji 'before'..." -ForegroundColor Gray
javac solid/liskov_substitution/before/*.java

Write-Host "[2/4] Kompilacja wersji 'after'..." -ForegroundColor Gray
javac solid/liskov_substitution/after/*.java

Write-Host ""
Write-Host "============================================" -ForegroundColor Red
Write-Host "  BEFORE - Naruszenie LSP" -ForegroundColor Red
Write-Host "============================================" -ForegroundColor Red
Write-Host ""

# Uruchomienie before
Write-Host "[3/4] Uruchomienie before/LspDemo..." -ForegroundColor Gray
java solid.liskov_substitution.before.LspDemo

Write-Host ""
Write-Host "============================================" -ForegroundColor Green
Write-Host "  AFTER - Zgodnie z LSP" -ForegroundColor Green
Write-Host "============================================" -ForegroundColor Green
Write-Host ""

# Uruchomienie after
Write-Host "[4/4] Uruchomienie after/LspDemo..." -ForegroundColor Gray
java solid.liskov_substitution.after.LspDemo

Write-Host ""
Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Gotowe!" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Porownanie:" -ForegroundColor Yellow
Write-Host "  BEFORE: Square nie jest podstawialny za Rectangle" -ForegroundColor Red
Write-Host "  AFTER:  Wszystkie ksztalty sa podstawialne za Shape" -ForegroundColor Green
Write-Host ""

