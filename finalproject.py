SUBTOTAL=[]
IGV=float()
TOTAL=float()
Ans=str()

while True:

    print("            |========================================|")
    print("            |  'Restobar La Cacerola de Tula S.A'    |")
    print("            |                   Menú                 |")
    print("            |========================================|")
    print("            | A |      Desayuno                      |")
    print("            | B |      Almuerzo                      |")
    print("            | C |      Cena                          |")
    print("            | D |==============SALIR=================|")
    print("            |========================================|")

    while True:

        Ans=(input("Elija una opcion del menú: "))
        Ans=str.upper(Ans)

        if Ans not in{"A","B","C","D"}:

            print("Opcion no disponible, ingrese otra")

        if Ans in {"A","B","C","D"}:
            break

    if Ans=="A":

        print("        |                Desayuno                |")
        print("        |========================================|")
        print("        | A |      Café                  |S/4.50 |")
        print("        | B |      Chocolate             |S/5.00 |")
        print("        | C |      Jugo de Fresas        |S/9.00 |")
        print("        | D |      Jugo de Papaya        |S/8.00 |")
        print("        | E |      Pan con Pollo         |S/7.00 |")
        print("        | F |      Pan con Jamón         |S/7.00 |")
        print("        | G |      Pan con Tamal         |S/7.00 |")
        print("        | H |================SALIR===============|")
        print("        |========================================|")
        
        while True:

          Ans=(input("Elija una opcion para el desayuno: "))
          Ans=str.upper(Ans)

          if Ans == "A":
            SUBTOTAL.append(4.5)

          elif Ans == "B":
            SUBTOTAL.append(5.0)

          elif Ans == "C":
            SUBTOTAL.append(9.0)

          elif Ans == "D":
           SUBTOTAL.append(8.0)

          elif Ans == "E":
            SUBTOTAL.append(7.0)
          elif Ans == "F":

            SUBTOTAL.append(7.0)

          elif Ans == "G":
            SUBTOTAL.append(7.0)

          elif Ans == "H":
            break

          else:
            print("Opción no disponible, ingrese otra")

    elif Ans=="B":

        print("        |                Almuerzo                |")
        print("        |========================================|")
        print("        | A |      Sopa de Pollo         |S/7.50 |")
        print("        | B |      Seco de Carne         |S/9.00 |")
        print("        | C |      Lomo Saltado         |S/14.00 |")
        print("        | D |      Caldo de Gallina     |S/10.00 |")
        print("        | E |      Ensalada de Palta     |S/8.00 |")
        print("        | F |      Pescado Frito         |S/9.00 |")
        print("        | G |      Lechón al Horno      |S/12.00 |")
        print("        | H |================SALIR===============|")
        print("        |========================================|")

        while True:
            Ans=(input("Elija una opción para el almuerzo: "))
            Ans=str.upper(Ans)

            if Ans == "A":
              SUBTOTAL.append(7.5)

            elif Ans == "B":
              SUBTOTAL.append(9.0)

            elif Ans == "C":
              SUBTOTAL.append(14.00)

            elif Ans == "D":
              SUBTOTAL.append(10.00)
            elif Ans == "E":
              SUBTOTAL.append(8.0)

            elif Ans == "F":
              SUBTOTAL.append(9.0)

            elif Ans == "G":
              SUBTOTAL.append(12.0)

            elif Ans == "H":
                break

            else:
                print("Opcion no disponible, ingrese otra")

    elif Ans == "C":
        print("        |                  Cena                  |")
        print("        |========================================|")
        print("        | A |      Pizza Express         |S/9.50 |")
        print("        | B |      Ensalada Campera      |S/9.00 |")
        print("        | C |      Gazpacho             |S/10.00 |")
        print("        | D |      Pollo a la Plancha   |S/10.00 |")
        print("        | E |      Menestrón             |S/6.50 |")
        print("        | F |      Tortilla de Pollo     |S/7.00 |")
        print("        | G |================SALIR===============|")
        print("        |========================================|")

        while True:

            Ans=(input("Elija una opción para la cena: "))
            Ans=str.upper(Ans)

            if Ans == "A":
              SUBTOTAL.append(9.5)

            elif Ans == "B":
              SUBTOTAL.append(9.0)

            elif Ans == "C":
              SUBTOTAL.append(10.00)

            elif Ans == "D":
              SUBTOTAL.append(10.00)

            elif Ans == "E":
              SUBTOTAL.append(6.5)

            elif Ans == "F":
              SUBTOTAL.append(7.0)

            elif Ans == "G":
                break

            else:
                print("Opcion no disponible, ingrese otra")

    elif Ans=="D":
        break

Suma=0
for i in SUBTOTAL:
  Suma=Suma+i

IGV=Suma*0.18
TOTAL=Suma+IGV

print("          |BOLETA DE VENTAS|         ")
print("=====================================")
print("Subtotal:",               "S/.",  Suma)
print("IGV    :",  "S/.","{:.2f}".format(IGV))
print("Total  :","S/.","{:.2f}".format(TOTAL))
print("                                     ")
print("=====================================")
print("        Gracias por su compra        ")


    




