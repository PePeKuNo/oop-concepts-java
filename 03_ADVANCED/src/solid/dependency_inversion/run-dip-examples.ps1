# Szybkie uruchomienie przykladow Dependency Inversion Principle
# Uzycie: Uruchom z katalogu 03_ADVANCED\src

$ErrorActionPreference = "Stop"

Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Dependency Inversion - Przyklady" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""

# Kompilacja
Write-Host "[1/3] Kompilacja wersji 'before'..." -ForegroundColor Gray
javac solid/dependency_inversion/before/*.java

Write-Host "[2/3] Kompilacja wersji 'after'..." -ForegroundColor Gray
javac solid/dependency_inversion/after/*.java

Write-Host ""
Write-Host "============================================" -ForegroundColor Green
Write-Host "  AFTER - Zgodnie z DIP" -ForegroundColor Green
Write-Host "============================================" -ForegroundColor Green
Write-Host ""

# Uruchomienie after (before nie ma demo)
Write-Host "[3/3] Uruchomienie after/UserServiceDemo..." -ForegroundColor Gray
java solid.dependency_inversion.after.UserServiceDemo

Write-Host ""
Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Gotowe!" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Wyjasnienie:" -ForegroundColor Yellow
Write-Host "  BEFORE: UserService zalezny od MySQLDatabase (konkretna klasa)" -ForegroundColor Red
Write-Host "  AFTER:  UserService zalezny od Database (abstrakcja)" -ForegroundColor Green
Write-Host "          Latwa zmiana MySQL -> MongoDB bez modyfikacji UserService" -ForegroundColor Green
Write-Host ""

