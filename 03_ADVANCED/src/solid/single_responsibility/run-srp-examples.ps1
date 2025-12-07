# Szybkie uruchomienie przykladow Single Responsibility Principle
# Uzycie: Uruchom z katalogu 03_ADVANCED\src

$ErrorActionPreference = "Stop"

Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Single Responsibility - Przyklady" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""

# Kompilacja
Write-Host "[1/4] Kompilacja wersji 'before'..." -ForegroundColor Gray
javac solid/single_responsibility/before/*.java

Write-Host "[2/4] Kompilacja wersji 'after'..." -ForegroundColor Gray
javac solid/single_responsibility/after/*.java

Write-Host ""
Write-Host "============================================" -ForegroundColor Red
Write-Host "  BEFORE - Naruszenie SRP" -ForegroundColor Red
Write-Host "============================================" -ForegroundColor Red
Write-Host ""

# Uruchomienie before
Write-Host "[3/4] Uruchomienie before/EmployeeDemo..." -ForegroundColor Gray
java solid.single_responsibility.before.EmployeeDemo | Select-Object -Last 15

Write-Host ""
Write-Host "============================================" -ForegroundColor Green
Write-Host "  AFTER - Zgodnie z SRP" -ForegroundColor Green
Write-Host "============================================" -ForegroundColor Green
Write-Host ""

# Uruchomienie after
Write-Host "[4/4] Uruchomienie after/EmployeeDemo..." -ForegroundColor Gray
java solid.single_responsibility.after.EmployeeDemo | Select-Object -Last 15

Write-Host ""
Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Gotowe!" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Porownanie:" -ForegroundColor Yellow
Write-Host "  BEFORE: Employee ma 4 rozne odpowiedzialnosci" -ForegroundColor Red
Write-Host "  AFTER:  Kazda klasa ma jedna odpowiedzialnosc" -ForegroundColor Green
Write-Host ""

