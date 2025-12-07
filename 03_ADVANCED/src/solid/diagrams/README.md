# Diagramy PlantUML - SOLID

Ten katalog zawiera diagramy PlantUML ilustrujące zasady SOLID.

## Pliki

- `solid_overview.puml` - Przegląd wszystkich 5 zasad SOLID
- `solid_relationships.puml` - Relacje między zasadami SOLID

## Generowanie obrazków PNG

### Metoda 1: Online (najłatwiejsza)

1. Otwórz https://www.plantuml.com/plantuml/uml/
2. Skopiuj zawartość pliku `.puml`
3. Wklej do edytora
4. Diagram się wygeneruje automatycznie
5. Pobierz jako PNG

### Metoda 2: PlantUML CLI

Jeśli masz zainstalowany PlantUML:

```powershell
# Pojedynczy plik
java -jar plantuml.jar solid_overview.puml

# Wszystkie diagramy
java -jar plantuml.jar **/*.puml
```

### Metoda 3: VS Code

Zainstaluj rozszerzenie "PlantUML" w VS Code:
1. Otwórz plik `.puml`
2. Naciśnij `Alt+D` aby zobaczyć podgląd
3. Eksportuj do PNG przez menu kontekstowe

## Uwagi techniczne

- Wszystkie diagramy używają `!theme plain` dla spójnego wyglądu
- Polskie znaki są zamienione na ASCII (ą→a, ę→e, etc.) dla kompatybilności
- Diagramy są zoptymalizowane do prezentacji w slajdach

## Weryfikacja składni

Aby sprawdzić poprawność wszystkich diagramów:

```powershell
.\validate-puml-diagrams.ps1
```

## Troubleshooting

### Problem: "Diagram nie się nie buduje"

1. Sprawdź czy plik ma znaczniki `@startuml` i `@enduml`
2. Usuń polskie znaki diakrytyczne
3. Sprawdź składnię korzystając z edytora online
4. Upewnij się, że kodowanie pliku to UTF-8

### Problem: "Niepoprawne wyświetlanie znaków"

PlantUML najlepiej działa z ASCII. Użyj transliteracji:
- ą → a
- ć → c
- ę → e
- ł → l
- ń → n
- ó → o
- ś → s
- ź, ż → z

## Format do prezentacji

Diagramy są projektowane z myślą o:
- Generowaniu slajdów przez Pandoc
- Wstawianiu do dokumentów Markdown
- Prezentacjach PowerPoint

Dla najlepszych rezultatów, generuj PNG w rozmiarze 1920x1080 (Full HD).

