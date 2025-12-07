# Test wszystkich przykładów SOLID
# Uruchom: .\test-all-solid-demos.ps1

$ErrorActionPreference = "Stop"

Write-Host "=================================" -ForegroundColor Cyan
Write-Host "Test wszystkich przykładów SOLID" -ForegroundColor Cyan
Write-Host "=================================" -ForegroundColor Cyan
Write-Host ""

# Przejdź do katalogu src
Set-Location C:\home\gitHub\oop-concepts-java\03_ADVANCED\src

# 1. Single Responsibility Principle
Write-Host ">>> 1. Single Responsibility Principle" -ForegroundColor Yellow
Write-Host "    Kompilacja..." -ForegroundColor Gray
javac solid/single_responsibility/before/*.java
javac solid/single_responsibility/after/*.java

Write-Host "    Before (naruszenie):" -ForegroundColor Red
java solid.single_responsibility.before.EmployeeDemo | Select-Object -Last 10

Write-Host "`n    After (rozwiązanie):" -ForegroundColor Green
java solid.single_responsibility.after.EmployeeDemo | Select-Object -Last 10

Write-Host "`n" + ("=" * 60) + "`n"

# 2. Open/Closed Principle
Write-Host ">>> 2. Open/Closed Principle" -ForegroundColor Yellow
Write-Host "    Kompilacja..." -ForegroundColor Gray
javac solid/open_closed/before/*.java
javac solid/open_closed/after/*.java

Write-Host "    Before (naruszenie):" -ForegroundColor Red
java solid.open_closed.before.AreaCalculatorDemo

Write-Host "`n    After (rozwiązanie):" -ForegroundColor Green
java solid.open_closed.after.ShapeDemo

Write-Host "`n" + ("=" * 60) + "`n"

# 3. Liskov Substitution Principle
Write-Host ">>> 3. Liskov Substitution Principle" -ForegroundColor Yellow
Write-Host "    Kompilacja..." -ForegroundColor Gray
javac solid/liskov_substitution/before/*.java
javac solid/liskov_substitution/after/*.java

Write-Host "    Before (naruszenie):" -ForegroundColor Red
java solid.liskov_substitution.before.LspDemo

Write-Host "`n    After (rozwiązanie):" -ForegroundColor Green
java solid.liskov_substitution.after.LspDemo

Write-Host "`n" + ("=" * 60) + "`n"

# 4. Interface Segregation Principle
Write-Host ">>> 4. Interface Segregation Principle" -ForegroundColor Yellow
Write-Host "    Kompilacja..." -ForegroundColor Gray
javac solid/interface_segregation/before/*.java
javac solid/interface_segregation/after/*.java

Write-Host "    After (rozwiązanie):" -ForegroundColor Green
java solid.interface_segregation.after.WorkerDemo

Write-Host "`n" + ("=" * 60) + "`n"

# 5. Dependency Inversion Principle
Write-Host ">>> 5. Dependency Inversion Principle" -ForegroundColor Yellow
Write-Host "    Kompilacja..." -ForegroundColor Gray
javac solid/dependency_inversion/before/*.java
javac solid/dependency_inversion/after/*.java

Write-Host "    After (rozwiązanie):" -ForegroundColor Green
java solid.dependency_inversion.after.UserServiceDemo

Write-Host "`n" + ("=" * 60) + "`n"

Write-Host "=================================" -ForegroundColor Cyan
Write-Host "✅ Wszystkie testy zakończone!" -ForegroundColor Green
Write-Host "=================================" -ForegroundColor Cyan

