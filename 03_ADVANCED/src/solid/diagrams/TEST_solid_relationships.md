# Test diagramu solid_relationships.puml w przeglądarce

## Instrukcja:

1. Skopiuj poniższy kod
2. Wejdź na: https://www.plantuml.com/plantuml/uml/
3. Wklej kod w edytorze
4. Sprawdź czy diagram się wyświetla

## Kod do skopiowania:

```plantuml
@startuml solid_relationships
!theme plain
skinparam shadowing false

title Relacje miedzy zasadami SOLID

rectangle "S - Single Responsibility\n\nJedna odpowiedzialnosc\n= jeden powod do zmiany" as SRP #LightBlue
rectangle "O - Open/Closed\n\nOtwarte na rozszerzanie\nZamkniete na modyfikacje" as OCP #LightGreen
rectangle "L - Liskov Substitution\n\nPodklasy podstawialne\nza klasy bazowe" as LSP #LightYellow
rectangle "I - Interface Segregation\n\nWiele malych interfejsow\nzamiast jednego duzego" as ISP #LightCoral
rectangle "D - Dependency Inversion\n\nZaleznosc od abstrakcji\nnie od szczegolow" as DIP #LightCyan

SRP -down-> OCP
OCP -down-> LSP
LSP -down-> ISP
ISP -down-> DIP

SRP .right.> ISP : wspiera
OCP .right.> DIP : wymaga

note right of SRP
  Fundament
  - Najprostsza zasada
  - Punkt startowy
end note

note right of OCP
  Rozszerzalnosc
  - Uzywa abstrakcji
  - Wzorce: Strategy,
    Factory, Template
end note

note right of LSP
  Poprawnosc
  - Kontrakty
  - Nie wzmacniaj
    preconditions
end note

note right of ISP
  Modularnosc
  - Male, spojne
    interfejsy
  - Niskie sprzezenie
end note

note right of DIP
  Abstrakcja
  - Dependency Injection
  - Latwe testowanie
  - Elastycznosc
end note

note bottom
  Jak zasady wspolpracuja:
  
  1. SRP -> OCP: Klasy z jedna odpowiedzialnoscia latwiej rozszerzac
  2. OCP -> DIP: Rozszerzanie wymaga abstrakcji
  3. LSP -> DIP: Podstawianie dziala gdy zalezmy od abstrakcji
  4. ISP -> SRP: Male interfejsy = pojedyncze odpowiedzialnosci
  5. ISP -> DIP: Segregowane interfejsy ulatwiaja DI
  
  Kolejnosc nauki: S -> O -> D -> L -> I
end note

@enduml
```

## Oczekiwany rezultat:

Diagram powinien pokazywać:
- 5 kolorowych prostokątów (S, O, L, I, D) ułożonych pionowo
- Strzałki łączące kolejne elementy
- Dodatkowe kropkowane strzałki (SRP->ISP, OCP->DIP)
- Notatki po prawej stronie dla każdej zasady
- Notatka na dole z podsumowaniem

## Jeśli działa:

✅ Diagram ma poprawną składnię PlantUML i można go używać!

## Jeśli nie działa:

❌ Sprawdź komunikat błędu w edytorze online i popraw składnię.

