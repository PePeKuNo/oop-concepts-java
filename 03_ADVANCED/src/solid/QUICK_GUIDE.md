# Szybki przewodnik po przykładach SOLID

## Przegląd wszystkich przykładów

### 1️⃣ Single Responsibility Principle (SRP)

**Idea**: Jedna klasa = jedna odpowiedzialność

#### Przykłady do uruchomienia:

```powershell
# Prosty przykład (bez pakietów)
cd 03_ADVANCED/src/solid
javac SimpleSrpDemo.java && java SimpleSrpDemo

# Pełny przykład PRZED (naruszenie)
cd 03_ADVANCED/src
javac solid/single_responsibility/before/*.java
java solid.single_responsibility.before.EmployeeDemo

# Pełny przykład PO (zgodność)
javac solid/single_responsibility/after/*.java
java solid.single_responsibility.after.EmployeeDemo
```

**Kluczowe pliki**:
- `Employee.java` (before) - klasa z wieloma odpowiedzialnościami ❌
- `Employee.java` (after) - tylko dane ✅
- `PayrollCalculator.java` - logika biznesowa ✅
- `EmployeeRepository.java` - persystencja ✅
- `EmployeeReportGenerator.java` - raportowanie ✅

---

### 2️⃣ Open/Closed Principle (OCP)

**Idea**: Otwarte na rozszerzanie, zamknięte na modyfikację

#### Przykłady do uruchomienia:

```powershell
# Prosty przykład
cd 03_ADVANCED/src/solid
javac SimpleOcpDemo.java && java SimpleOcpDemo

# Pełny przykład PRZED
cd 03_ADVANCED/src
javac solid/open_closed/before/*.java

# Pełny przykład PO
javac solid/open_closed/after/*.java
java solid.open_closed.after.ShapeDemo
```

**Kluczowe pliki**:
- `AreaCalculator.java` (before) - używa instanceof ❌
- `Shape.java` (after) - interfejs, stabilna abstrakcja ✅
- `Rectangle.java`, `Circle.java`, `Triangle.java` - implementacje ✅
- `AreaCalculator.java` (after) - działa z abstrakcją ✅

**Demonstracja**: Dodaj `Triangle` bez modyfikacji istniejącego kodu!

---

### 3️⃣ Liskov Substitution Principle (LSP)

**Idea**: Podklasy muszą być podstawialne za klasy bazowe

#### Przykłady do uruchomienia:

```powershell
cd 03_ADVANCED/src

# Problem Rectangle-Square (naruszenie)
javac solid/liskov_substitution/before/*.java
java solid.liskov_substitution.before.LspDemo

# Rozwiązanie (zgodność)
javac solid/liskov_substitution/after/*.java
java solid.liskov_substitution.after.LspDemo
```

**Kluczowe pliki**:
- `Rectangle.java` + `Square.java` (before) - Square narusza kontrakt ❌
- `Shape.java` (after) - interfejs dla obu ✅
- `Rectangle.java`, `Square.java` (after) - niezależne implementacje ✅

**Demonstracja**: Square jako podklasa Rectangle psuje test powierzchni!

---

### 4️⃣ Interface Segregation Principle (ISP)

**Idea**: Wiele małych interfejsów > jeden duży

#### Przykłady do uruchomienia:

```powershell
cd 03_ADVANCED/src

# Problem (before)
javac solid/interface_segregation/before/*.java

# Rozwiązanie (after)
javac solid/interface_segregation/after/*.java
java solid.interface_segregation.after.WorkerDemo
```

**Kluczowe pliki**:
- `Worker.java` (before) - "fat interface" ❌
- `Robot.java` (before) - zmuszony do pustych implementacji ❌
- `Workable.java`, `Eatable.java`, `Sleepable.java`, `Payable.java` (after) - małe interfejsy ✅
- `Robot.java` (after) - implementuje tylko Workable ✅
- `Human.java` (after) - implementuje wszystkie potrzebne ✅

**Demonstracja**: Robot nie musi implementować metod eat() i sleep()!

---

### 5️⃣ Dependency Inversion Principle (DIP)

**Idea**: Zależymy od abstrakcji, nie konkretnych klas

#### Przykłady do uruchomienia:

```powershell
cd 03_ADVANCED/src

# Problem (before)
javac solid/dependency_inversion/before/*.java

# Rozwiązanie (after)
javac solid/dependency_inversion/after/*.java
java solid.dependency_inversion.after.UserServiceDemo
```

**Kluczowe pliki**:
- `UserService.java` (before) - tworzy MySQLDatabase bezpośrednio ❌
- `Database.java` (after) - interfejs (abstrakcja) ✅
- `MySQLDatabase.java`, `MongoDatabase.java` (after) - implementacje ✅
- `UserService.java` (after) - przyjmuje Database przez konstruktor (DI) ✅

**Demonstracja**: Łatwa zmiana z MySQL na MongoDB bez modyfikacji UserService!

---

## 🚀 Uruchamianie wszystkich przykładów na raz

### Gotowy skrypt automatyczny:

```powershell
cd C:\home\gitHub\oop-concepts-java\03_ADVANCED\src

# Uruchom wszystkie testy SOLID
.\test-all-solid.ps1

# Lub pojedyncze zasady:
.\solid\single_responsibility\run-srp-examples.ps1
.\solid\open_closed\run-ocp-examples.ps1
.\solid\liskov_substitution\run-lsp-examples.ps1
.\solid\interface_segregation\run-isp-examples.ps1
.\solid\dependency_inversion\run-dip-examples.ps1
```

### Walidacja diagramów:

```powershell
cd C:\home\gitHub\oop-concepts-java\03_ADVANCED\src
.\validate-puml-diagrams.ps1
```

Skrypt `test-all-solid.ps1` automatycznie:
- Kompiluje wszystkie przykłady
- Uruchamia demo dla każdej zasady
- Pokazuje porównania "before" vs "after"
- Czyści pliki `.class` po zakończeniu

---

## Testy jednostkowe

### Uruchomienie testów SRP:

```powershell
cd 03_ADVANCED/src

# Zakładając że masz JUnit 5 w classpath
javac -cp ".;junit-platform-console-standalone.jar" `
  solid/single_responsibility/tests/*.java `
  solid/single_responsibility/after/*.java

java -jar junit-platform-console-standalone.jar `
  --class-path . `
  --select-class solid.single_responsibility.after.PayrollCalculatorTest
```

---

## 📊 Przeglądanie diagramów PlantUML

Wszystkie diagramy są w katalogach `diagrams/` jako pliki `.puml`.

### Opcje przeglądania:

1. **VS Code** - zainstaluj rozszerzenie PlantUML dla podglądu na żywo
2. **PlantUML Web Server** - http://www.plantuml.com/plantuml/uml/
3. **Lokalne generowanie PNG** (opcjonalnie):

```powershell
# Pojedynczy diagram
java -jar plantuml.jar solid/single_responsibility/diagrams/srp_violation.puml

# Wszystkie diagramy w zasadzie
java -jar plantuml.jar solid/single_responsibility/diagrams/*.puml

# Wszystkie diagramy SOLID
java -jar plantuml.jar solid/**/diagrams/*.puml
```

**Dostępne diagramy** (17 plików `.puml`):
- **SRP**: srp_violation, srp_solution, srp_class_diagram
- **OCP**: ocp_violation, ocp_solution, ocp_strategy, ocp_class_diagram
- **LSP**: lsp_rectangle_problem, lsp_solution
- **ISP**: isp_violation, isp_solution, isp_class_diagram
- **DIP**: dip_violation, dip_solution, dip_class_diagram
- **Przegląd**: solid_overview, solid_relationships

---

## Generowanie prezentacji

### Wszystkie prezentacje naraz:

```powershell
cd 03_ADVANCED/src/solid

# Pojedyncze zasady
pandoc single_responsibility/README.md -o SRP.pptx
pandoc open_closed/README.md -o OCP.pptx
pandoc liskov_substitution/README.md -o LSP.pptx
pandoc interface_segregation/README.md -o ISP.pptx
pandoc dependency_inversion/README.md -o DIP.pptx

# Przegląd wszystkich zasad
pandoc README.md -o SOLID_Overview.pptx
```

---

## Porównanie: Przed vs Po

### SRP - Employee

| Przed | Po |
|-------|-----|
| 1 klasa z 4 odpowiedzialnościami | 4 klasy, każda z 1 odpowiedzialnością |
| Trudne testowanie | Łatwe testowanie każdej osobno |
| Wysokie sprzężenie | Niskie sprzężenie |

### OCP - Shape Calculator

| Przed | Po |
|-------|-----|
| Modyfikacja przy każdym nowym kształcie | Dodanie klasy bez modyfikacji |
| instanceof/switch | Polimorfizm |
| Wysokie ryzyko regresji | Niskie ryzyko |

### LSP - Rectangle/Square

| Przed | Po |
|-------|-----|
| Square dziedziczy Rectangle | Oba implementują Shape |
| Naruszenie kontraktu | Własne kontrakty |
| Test failuje dla Square | Wszystkie podstawialne |

### ISP - Worker

| Przed | Po |
|-------|-----|
| 1 duży interfejs Worker | 4 małe interfejsy |
| Robot musi implementować eat/sleep | Robot tylko Workable |
| UnsupportedOperationException | Pełne implementacje |

### DIP - UserService

| Przed | Po |
|-------|-----|
| Zależność od MySQLDatabase | Zależność od Database (interface) |
| Nie można zmienić bazy | Łatwa zmiana przez DI |
| Niemożliwe mockowanie | Łatwe mockowanie |

---

## Wskazówki do nauki

### Kolejność nauki zasad:

1. **SRP** - najprostsza, fundamentalna
2. **OCP** - buduje na SRP
3. **DIP** - ważna dla OCP
4. **LSP** - wymaga zrozumienia dziedziczenia
5. **ISP** - uzupełnia pozostałe

### Kluczowe pytania przy projektowaniu:

- **SRP**: Czy klasa ma więcej niż jeden powód do zmiany?
- **OCP**: Czy mogę dodać funkcję bez modyfikacji?
- **LSP**: Czy podklasa może zastąpić klasę bazową?
- **ISP**: Czy klient jest zmuszony do zależności od nieużywanych metod?
- **DIP**: Czy zależę od abstrakcji czy konkretnej implementacji?

---

## Dodatkowe przykłady do samodzielnego ćwiczenia

1. **SRP**: Zrefaktoruj klasę `Book` z metodami print(), save(), format()
2. **OCP**: Dodaj nowy kształt `Pentagon` do systemu
3. **LSP**: Napraw hierarchię `Account` -> `SavingsAccount`
4. **ISP**: Rozbij interfejs `MultiFunctionPrinter`
5. **DIP**: Dodaj `LoggerService` z różnymi implementacjami

---

**Powodzenia w nauce zasad SOLID!** 🚀

