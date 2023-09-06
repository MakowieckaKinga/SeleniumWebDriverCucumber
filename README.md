# SeleniumWebDriverCucumber

## **Scenariusz #1 :"Dodanie nowego adresu".** <br>

**Dane wyjściowe:** <br>
**Użytkownik posiada konto na stronie https://mystore-testlab.coderslab.pl.**

1. Logowanie Użytkownika na stronie https://mystore-testlab.coderslab.pl.
2. Użytkownik przechodzi do sekcji "Addresses" (adres, na którym powinniśmy się znaleźć to: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ).
3. Użytkownik klika w "Create new address".
4. Wypełnienie formularza "New address" danymi - powinny być pobierane z tabeli Examples w Gherkinie (alias, address, city, zip/postal code, phone).
5. Użytkownik przesyła formularz.


## **Scenariusz #2 :"Zakup produktu".** <br>

**Dane wyjściowe:** <br>
 **Użytkownik posiada konto na stronie https://mystore-testlab.coderslab.pl.** <br> 
**Użytkownik posiada dodany adres do wysyłki.**

1. Logowanie Użytkownika na stronie https://mystore-testlab.coderslab.pl.
2. Użytkownik wybiera produkt "Hummingbird Printed Sweater".
3. Wybór rozmiaru M.
4. Użytkownik dodaje 5 pozycji.
5. Dodanie produktów do koszyka.
6. Przejście do "checkout".
7. Użytkownik potwierdza "address".
8. Wybór metody odbioru - "pick up in store".
9. Wybór opcji płatności - "Pay by Check".
10. Wykonanie screenshota z potwierdzeniem zamówienia i kwotą.