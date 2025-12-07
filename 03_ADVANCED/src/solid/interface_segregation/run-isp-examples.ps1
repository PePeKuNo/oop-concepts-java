# Szybkie uruchomienie przykladow Interface Segregation Principle
# Uzycie: Uruchom z katalogu 03_ADVANCED\src

$ErrorActionPreference = "Stop"

Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Interface Segregation - Przyklady" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""

# Kompilacja
Write-Host "[1/3] Kompilacja wersji 'before'..." -ForegroundColor Gray
javac solid/interface_segregation/before/*.java

Write-Host "[2/3] Kompilacja wersji 'after'..." -ForegroundColor Gray
javac solid/interface_segregation/after/*.java

Write-Host ""
Write-Host "============================================" -ForegroundColor Green
Write-Host "  AFTER - Zgodnie z ISP" -ForegroundColor Green
Write-Host "============================================" -ForegroundColor Green
Write-Host ""

# Uruchomienie after (before nie ma demo)
Write-Host "[3/3] Uruchomienie after/WorkerDemo..." -ForegroundColor Gray
java solid.interface_segregation.after.WorkerDemo

Write-Host ""
Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Gotowe!" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Wyjasnienie:" -ForegroundColor Yellow
Write-Host "  BEFORE: Robot musiał implementowac eat() i sleep()" -ForegroundColor Red
Write-Host "  AFTER:  Robot implementuje tylko Workable" -ForegroundColor Green
Write-Host ""

