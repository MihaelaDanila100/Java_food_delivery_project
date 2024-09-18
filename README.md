# Java Project - Advanced Object Oriented Programming

### Proiectul este ales pe tema Food Delivery. 
##### Acesta contine 12 clase grupate in 4 pachete si o clasa serviciu.
<ol>
  <li>
    In primul pachet (pachetLocaluri) sunt grupate clasele ce reprezinta tipurile posibile de localuri de la care vine mancarea comandata de utilizator
    <ul>
      <li> <b>Restauranturi</b></li>
      <li> Supermarket </li>
      <li> Baruri </li>
    </ul>
    Aceste 3 clase mostenesc o clasa de baza Localuri, care contine informatiile de baza pe care trebuie sa le contina orice local, indiferent de tip.
  </li>
  
  <li>
    In al doilea pachet (pachetLogistica) sunt grupate clasele ce tin de organizarea aplicatiei
    <ul>
      <li> Masini</li>
      <li> Soferi</li>
    </ul>
  </li>
  
  <li>
    In al treilea pachet (pachetProduse) sunt grupate clasele ce tin de produsele care sunt comercializate in localuri
    <ul>
      <li> Bauturi</li>
      <li> Preparate</li>
    </ul>
  </li>
  
  <li>
    In al patrulea pachet (pachetUsers) sunt grupatele clasele care tin de utilizatori si facilitatile acestora.
    <ul>
      <li> Useri</li>
      <li> 
        Comenzi, care cotine informatiile de baza pe care trebuie sa le contina orice comanda, iar apoi sunt 2 clase care o mostenesc:
          <ul>
            <li> ComenziBaruri</li>
            <li> ComenziRestaurante</li>
          </ul>
      </li>
    </ul>
  </li>
</ol>
