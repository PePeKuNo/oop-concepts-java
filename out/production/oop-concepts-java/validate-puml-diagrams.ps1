# Walidacja skladni wszystkich diagramow PlantUML
# Sprawdza czy pliki .puml maja poprawna strukture

$ErrorActionPreference = "Continue"

Write-Host "=================================" -ForegroundColor Cyan
Write-Host "Walidacja diagramow PlantUML" -ForegroundColor Cyan
Write-Host "=================================" -ForegroundColor Cyan
Write-Host ""

$srcPath = "C:\home\gitHub\oop-concepts-java\03_ADVANCED\src\solid"
$pumlFiles = Get-ChildItem -Path $srcPath -Filter "*.puml" -Recurse

$totalFiles = $pumlFiles.Count
$validFiles = 0
$invalidFiles = 0

foreach ($file in $pumlFiles) {
    $relativePath = $file.FullName.Replace($srcPath + "\", "")
    Write-Host "Sprawdzam: $relativePath" -NoNewline

    $content = Get-Content $file.FullName -Raw -Encoding UTF8

    # Sprawdz podstawowe elementy skladni PlantUML
    $hasStart = $content -match '@startuml'
    $hasEnd = $content -match '@enduml'

    if ($hasStart -and $hasEnd) {
        Write-Host " [OK]" -ForegroundColor Green
        $validFiles++
    } else {
        Write-Host " [ERROR]" -ForegroundColor Red
        if (-not $hasStart) {
            Write-Host "  - Brak @startuml" -ForegroundColor Yellow
        }
        if (-not $hasEnd) {
            Write-Host "  - Brak @enduml" -ForegroundColor Yellow
        }
        $invalidFiles++
    }
}

Write-Host ""
Write-Host "=================================" -ForegroundColor Cyan
Write-Host "Podsumowanie:" -ForegroundColor Cyan
Write-Host "  Laczna liczba plikow: $totalFiles" -ForegroundColor White
Write-Host "  Poprawne: $validFiles" -ForegroundColor Green
Write-Host "  Niepoprawne: $invalidFiles" -ForegroundColor $(if ($invalidFiles -eq 0) { "Green" } else { "Red" })
Write-Host "=================================" -ForegroundColor Cyan

if ($invalidFiles -eq 0) {
    Write-Host "`nWszystkie diagramy PlantUML sa poprawne!" -ForegroundColor Green
    exit 0
} else {
    Write-Host "`nZnaleziono bledy w diagramach!" -ForegroundColor Red
    exit 1
}

