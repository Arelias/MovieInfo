Opis projektu:
1. Projekt pierwotnie miał służyć jako platforma do porównywania cen między sklepami (Amazon oraz Ebay UK)
2. Ze względu na bezpodstawną blokadę API ze strony Amazona, projekt musiał zostać porzucony w dosyć zaawansowanym etapie
- (niestety supportu Kodilli to w żaden sposób nie interesowało)
3. Stworzony został drugi projekt MoviesInfo, który miał domyślnie stać się platformą umożliwiającą użytkownikom na:
a) Wyszukiwanie informacji o filmach, które już wyszły jak i o tych nadchodzących (wraz z plakatami)
b) Tworzenie konta i tworzenie własnych kolekcji filmów, oraz recenzowania ich
c) Wgląd w statystyki popularności różnych użytkowników, ich recenzji, najpopularniejszych filmów (zapisanych w najwieksze liczbie list) etc.
e) Tworzenie przypomnien dla nadchodzacych filmow, które wyswietlalyby sie zarowno na stronie jak i w skrzynkach mailowych
f) Oraz kilka innych.

Projekt niestety jest w bardzo poczatkowej fazie, komunikuje sie z API, pozwala na rejestracje, potwierdzenie konta oraz logowanie,
nie posiada jednak ani frontendu, ani testow, w zwiazku z czym nie ma zbyt duzo do opisania, w pliku konfiguracyjnym aplikacji 
istnieja dwie wartosci, mail username oraz mail password, wymagaja one stworzenia zmiennych systemowych w celu poprawnego 
dzialania czesci serwisu odpowiadajacej za wysylanie maili.
