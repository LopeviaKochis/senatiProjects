import tkinter as Tk
from tkinter import *
from tkinter import messagebox as MessageBox

def calcularTotal():
#En esta función está la logica de calcular el total y subtotal de ventas asignado por un precio por el usuario junto con la declaracion de try- except
    try:
    #Accediendo a los valores mediante el metodo get de cantidad y precio.
        cantidad=int(obtenerCantidad.get())
        cantidad1=int(obtenerCantidad1.get())
        cantidad2=int(obtenerCantidad2.get())
        precio=float(obtenerPrecio.get())
        precio1=float(obtenerPrecio1.get())
        precio2=float(obtenerPrecio2.get())
    #calculo del subtotal de ventas
        subtotal=round(cantidad*precio,2)
        subtotal1=round(cantidad1*precio1,2)
        subtotal2=round(cantidad2*precio2,2)
    #calculo del IGV
        IGV = round(0.18*subtotal + 0.18*subtotal1 + 0.18*subtotal2,2)
    #calculo del total de ventas
        total=round(subtotal+subtotal1+subtotal2+IGV,2)
    #fijando los valores mediane el metodo set a subtotal y total     
        obtenerSubtotal.set(str(subtotal))
        obtenerSubtotal1.set(str(subtotal1))
        obtenerSubtotal2.set(str(subtotal2))
    #fijando los valores mediane el metodo set a total
        obtenerTotal.set(str(total))
        

    except ValueError:
            MessageBox.showinfo("AVISO","""En la columna Cantidad o Precio hay valores incorrectos.
    Ingrese solo numeros y evite dejar celdas vacias.
                       
     ------------------ Mensaje de ayuda---------------------
        
    Solo ingrese los codigos de productos y el sistema mostrar los precios""")

    
def mostrarInformacion():
    """ esta funcion obtiene por condicionales los valores predeterminado para la casilla codigo de producto, descripcion, unidad y precio"""
#Accediendo a los valores mediante el metodo get de codigo, descripcion, unidad y precio
    try:
        codigo=int(obtenerCodigo.get())
        codigo1=int(obtenerCodigo1.get())
        codigo2=int(obtenerCodigo2.get())
        descripcion=obtenerDescripcion.get()
        descripcion1=obtenerDescripcion1.get()
        descripcion2=obtenerDescripcion2.get()

        precio=obtenerPrecio.get()
        precio1=obtenerPrecio1.get()
        precio2=obtenerPrecio2.get()

        unidad=obtenerUnidad.get()
        unidad1=obtenerUnidad1.get()
        unidad2=obtenerUnidad2.get()

#obteniendo valores predefinidos por condicionales para codigo de producto, descripcion, unidad y precio
#condicion para la primera columna de codigo de producto, precio y unidad
        if codigo in range (1,10):
            precio= 15.5
            descripcion= "pegamentos"
            unidad= "kilos"
        elif codigo in range (11,20):
            precio= 23.80
            descripcion="fierros"
            unidad= "metros"
        elif codigo in range (21, 30):
             precio= 19.8
             descripcion= "pinturas"
             unidad= "litros"
        else:
             MessageBox.showinfo("AVISO","""Solo se admiten codigos de producto del 1 al 30""" )

#condicion para la segunda columna de codigo de producto, precio y unidad
        if codigo1 in range (1,10):
            precio1= 15.5
            descripcion1= "pegamentos"
            unidad1= "kilos"
        elif codigo1 in range (11,20):
            precio1= 23.80
            descripcion1= "fierros"
            unidad1= "metros"
        elif codigo1 in range (21, 30):
            precio1= 19.8
            descripcion1= "pinturas"
            unidad1= "litros"
        else:
             MessageBox.showinfo("AVISO","""Solo se admiten codigos de producto del 1 al 30""" )

#condicion para la tercera columna de codigo de producto, precio y unidad
        if codigo2 in range (1,10):
            precio2= 15.5
            descripcion2= "pegamentos"
            unidad2= "kilos"
        elif codigo2 in range (11,20):
            precio2= 23.80
            descripcion2= "fierros"
            unidad2= "metros"
        elif codigo2 in range (21, 30):
             precio2= 19.8
             descripcion2= "pinturas"
             unidad2= "litros"
        else:
             MessageBox.showinfo("AVISO","""Solo se admiten codigos de producto del 1 al 30""" )

 #fijando los valores mediane el metodo set a precio, descripcion, codigo y unidad
        obtenerPrecio.set(str(precio))
        obtenerPrecio1.set(str(precio1))
        obtenerPrecio2.set(str(precio2))
        
        obtenerDescripcion.set(str(descripcion))
        obtenerDescripcion1.set(str(descripcion1))
        obtenerDescripcion2.set(str(descripcion2))

        obtenerCodigo.set(str(codigo))
        obtenerCodigo1.set(str(codigo1))
        obtenerCodigo2.set(str(codigo2))

        obtenerUnidad.set(str(unidad))
        obtenerUnidad1.set(str(unidad1))
        obtenerUnidad2.set(str(unidad2))
    except ValueError:
            MessageBox.showinfo("AVISO","""En la columna Cod_Prod ingresar un numero valido.
Evite dejar celdas vacias.
    
NOTA: Los codigos de productos solo son numeros del 1 al 30.""")


def Limpiar():
#Esta funcion limpia o reinicia los valores a cero, permitiendo ingresar los valores nuevos por el usuario
#Accediendo a los valores mediante el metodo get a todos las celdas del segundo frame
    obtenerCodigo.set("")
    obtenerCodigo1.set("")
    obtenerCodigo2.set("")
    obtenerDescripcion.set("")
    obtenerDescripcion1.set("")
    obtenerDescripcion2.set("")
    obtenerUnidad.set("")
    obtenerUnidad1.set("")
    obtenerUnidad2.set("")
    obtenerCantidad.set("")
    obtenerCantidad1.set("")
    obtenerCantidad2.set("")
    obtenerPrecio.set("")
    obtenerPrecio1.set("")
    obtenerPrecio2.set("")
    obtenerSubtotal.set("")
    obtenerSubtotal1.set("")
    obtenerSubtotal2.set("")
    obtenerTotal.set("")

def Salir():
#Esta funcion cierra la ventana matriz
     root.destroy()

root = Tk()#root = nombre de mi ventana matriz
root.title('Ferretería El tornillo feliz') # nombre del titulo de mi ventana
root.config(bg= "#DAB100") # background o fondo de mi ventana
root.iconbitmap('Martillo.ico')# imagen con el icono de mi ventana
root.resizable(0,0)#evita que se expanda mi ventana


miFrame = Frame(root)#ventana matriz
miFrame.pack()#empaquetando
miFrame.config(bg = "#DAB100")#fondo de mi frame matriz

#Insertamos los widgets
#Titulo mostrado en ventana matriz
lTitulo = Label(miFrame, text='Ferreteria El Tornillo Feliz', font=("calibri", 18),bg= "#DAB100" )
lTitulo.grid(row=0, column=2, pady=10, padx=10)

#Label y entry de DNI 
obtenerDni=StringVar() 
lDni = Label(miFrame, text='DNI:')
lDni.grid(row=5, column=0, sticky='e', pady=5, padx=5)
tDni = Entry(miFrame,textvariable=obtenerDni)
tDni.grid(row=5, column=1, pady=5, padx=5)
#Label y entry Apellido
obtenerApellido=StringVar() 
lApellido = Label(miFrame, text='Apellido:')
lApellido.grid(row=6, column=0, sticky='e', pady=5, padx=5)
tApellido = Entry(miFrame,textvariable=obtenerApellido)
tApellido.grid(row=6, column=1, pady=5, padx=5)
#Label y entry Nombre 
obtenerNombre=StringVar()
lNombre = Label(miFrame, text='Nombre:')
lNombre.grid(row=6, column=2, sticky='e', pady=5, padx=5)
tNombre = Entry(miFrame,textvariable=obtenerNombre)
tNombre.grid(row=6, column=3, pady=5, padx=5)
#Label y entry Diección
obtenerDir=StringVar() 
lDireccion = Label(miFrame, text='Dirección:')
lDireccion.grid(row=7, column=0, sticky='e', pady=5, padx=5)
tDireccion = Entry(miFrame,textvariable=obtenerDir)
tDireccion.grid(row=7, column=1, columnspan=3, sticky='we',pady=5, padx=5)
#Label y entry Teléfono
obtenerTel=StringVar() 
lTel = Label(miFrame, text='Teléfono:')
lTel.grid(row=8, column=0, sticky='e', pady=5, padx=5)
tTel = Entry(miFrame,textvariable=obtenerTel)
tTel.grid(row=8, column=1,columnspan=3, sticky='we', pady=5, padx=5)

#segundo frame, contendra a los campos relacionados al producto y precios
miFrame1 = Frame(root)
miFrame1.pack()

obtenerCodigo = StringVar()
obtenerCodigo1 = StringVar()
obtenerCodigo2 = StringVar()

#Label y entry Código Producto
lCodigo = Label(miFrame1, text='Cod_Prod')
lCodigo.grid(row=9, column=0,sticky='e', pady=5, padx=5)
tCodigo1 = Entry(miFrame1, width=7, textvariable =obtenerCodigo)
tCodigo1.grid(row=10, column=0, pady=5, padx=5)
tCodigo2 = Entry(miFrame1, width=7,textvariable =obtenerCodigo1 )
tCodigo2.grid(row=11, column=0, pady=5, padx=5)
tCodigo3 = Entry(miFrame1, width=7,textvariable =obtenerCodigo2)
tCodigo3.grid(row=12, column=0, pady=5, padx=5)

#nombres de mis variables descripcion
obtenerDescripcion = StringVar() 
obtenerDescripcion1 =StringVar()
obtenerDescripcion2 =StringVar()
#Label y entry Descripcion
lDes = Label(miFrame1, text='Descripción')
lDes.grid(row=9, column=1,sticky='ew', pady=5, padx=5)
tDes1 = Entry(miFrame1, width=7, state="readonly",textvariable = obtenerDescripcion)
tDes1.grid(row=10, column=1, pady=5, padx=5)
tDes2 = Entry(miFrame1, width=7, state="readonly",textvariable = obtenerDescripcion1)
tDes2.grid(row=11, column=1, pady=5, padx=5)
tDes3 = Entry(miFrame1, width=7, state="readonly",textvariable = obtenerDescripcion2)
tDes3.grid(row=12, column=1, pady=5, padx=5)

#nombres de mis variables unidad
obtenerUnidad = StringVar() 
obtenerUnidad1 = StringVar()
obtenerUnidad2 = StringVar()
#Label y entry Unidad
lUni = Label(miFrame1, text='Unidad_Medida')
lUni.grid(row=9, column=2,sticky='ew', pady=5, padx=5)
tUni1 = Entry(miFrame1, width=7, state="readonly", textvariable = obtenerUnidad)
tUni1.grid(row=10, column=2, pady=5, padx=5)
tUni2 = Entry(miFrame1, width=7, state="readonly",textvariable = obtenerUnidad1 )
tUni2.grid(row=11, column=2, pady=5, padx=5)
tUni3 = Entry(miFrame1, width=7, state="readonly",textvariable = obtenerUnidad2)
tUni3.grid(row=12, column=2, pady=5, padx=5)

#nombres de mis variables cantidad
obtenerCantidad = StringVar()
obtenerCantidad1 = StringVar()
obtenerCantidad2 = StringVar()
#Label y entry Cantidad
lCantidad = Label(miFrame1, text='Cantidad')
lCantidad.grid(row=9, column=3,sticky='ew', pady=5, padx=5)
tCantidad1 = Entry(miFrame1, width=7, textvariable = obtenerCantidad)
tCantidad1.grid(row=10, column=3, pady=5, padx=5)
tCantidad2 = Entry(miFrame1, width=7, textvariable = obtenerCantidad1)
tCantidad2.grid(row=11, column=3, pady=5, padx=5)
tCantidad3 = Entry(miFrame1, width=7, textvariable = obtenerCantidad2)
tCantidad3.grid(row=12, column=3, pady=5, padx=5)

#Nombres de mis variables precio
obtenerPrecio = StringVar()
obtenerPrecio1 = StringVar()
obtenerPrecio2 = StringVar()
#Label y entry Precio
lPrecio = Label(miFrame1, text='Precio S/.')
lPrecio.grid(row=9, column=4,sticky='ew', pady=5, padx=5)
tPrecio1 = Entry(miFrame1, width=7, state="readonly", textvariable = obtenerPrecio)
tPrecio1.grid(row=10, column=4, pady=5, padx=5)
tPrecio2 = Entry(miFrame1, width=7, state="readonly", textvariable = obtenerPrecio1)
tPrecio2.grid(row=11, column=4, pady=5, padx=5)
tPrecio3 = Entry(miFrame1, width=7, state="readonly", textvariable = obtenerPrecio2)
tPrecio3.grid(row=12, column=4, pady=5, padx=5)

#nombres de mis variables subtotal
obtenerSubtotal = StringVar()
obtenerSubtotal1 = StringVar()
obtenerSubtotal2 = StringVar()
#Label y entry Subtotal
lSubtotal = Label(miFrame1, text='Subtotal S/.')
lSubtotal.grid(row=9, column=5,sticky='ew', pady=5, padx=5)
tSubtotal = Entry(miFrame1, width=7, state="readonly",textvariable = obtenerSubtotal)
tSubtotal.grid(row=10, column=5, pady=5, padx=5)
tSubtotal1 = Entry(miFrame1, width=7, state="readonly",textvariable = obtenerSubtotal1)
tSubtotal1.grid(row=11, column=5, pady=5, padx=5)
tSubtotal2 = Entry(miFrame1, width=7, state="readonly",textvariable = obtenerSubtotal2)
tSubtotal2.grid(row=12, column=5, pady=5, padx=5)

#Label y entry Total
obtenerTotal = StringVar() # Nombre de la variable de total
lTotal = Label(miFrame1, text='Total S/. :',font=("calibri", 12))
lTotal.grid(row=12, column=6,sticky='ew', padx=5, pady=5)
tTotal = Entry(miFrame1, width=7, state="readonly", textvariable = obtenerTotal)
tTotal.grid(row=12, column=7, padx=5, pady=5)
#Botón calcular Total
guardar=Button(miFrame1, text='Calcular',font=("calibri", 12),bg= "green", command=calcularTotal)
guardar.grid(row=11, column=6, padx=10, pady=10)

#boton Informacion de Producto
guardar=Button(miFrame1, text='Informacion Producto',font=("calibri", 12),bg= "yellow", command=mostrarInformacion)
guardar.grid(row=13, column=0, padx=5, pady=5)

#boton Limpiar Campos
limpiar=Button(miFrame1, text='Limpiar', font=("calibri", 12),bg= "yellow", command=Limpiar)
limpiar.grid(row=13, column=1, padx=5, pady=5)

#boton Salir (cierra la ventana)
salir=Button(miFrame, text='Salir', font=("calibri", 12),bg= "red", command=Salir)
salir.grid(row=13, column=6, padx=5, pady=5)

root.mainloop()
