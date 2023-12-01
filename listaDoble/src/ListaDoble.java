public class ListaDoble{

	Node topForward;
	Node topBackward;

	//Métodos para los casos de inserción de nodos
	public boolean insertaPrimerNodo(String dato){
		if (topForward == null) { //La lista está vacía
			topForward = new Node();
			topForward.name = dato;
			topForward.previous = null;
			topForward.next = null;
			
			topBackward = topForward;

			return true;
		}
		else {
			return false;
		}
	}
	
	public void imprimir(){
		System.out.print("[.]"); 

		for (Node temp = this.topForward; temp != null; temp = temp.next){
			System.out.print(" <- [ " + temp.name + " ] -> ");
		}

		System.out.print("[.]\n"); 
	}
	
	public String toString(){
		String cadAux = "[..]";
		for (Node temp = this.topForward; temp != null; temp = temp.next){
			cadAux += " <- [ " + temp.name + " ] -> ";
		}

		cadAux += "[..]\n"; 

		return cadAux;
	}

	public void insertaAntesPrimerNodo(String nombre){
		Node temp; 
		temp = new Node ();
		temp.name = nombre;
		temp.next = this.topForward;
		this.topForward.previous = temp;
		this.topForward = temp;
		temp = null;
	}

	public void insertaAlFinal(String nombre){
		Node temp = new Node ();
		temp.name = nombre;
		temp.next = null;
		
		temp.previous = this.topBackward;
		this.topBackward.next = temp;
		this.topBackward = temp;
		temp = null;
	}

	public boolean insertaEntreNodos(String nombre, String buscado){
		Node temp = new Node();
		temp.name = nombre;
		Node temp2 = this.topForward;

		//boolean NodoNoEncontrado = true;

		while ( (temp2 != null) 
				&& temp2.name.equals(buscado) == false ) {	
		         temp2 = temp2.next;
		}

		if (temp2 != null){  //Nodo buscado se encontró
			temp.next = temp2.next;
			temp2.next = temp;

			temp.previous = temp2;
			temp.next.previous = temp;

			temp = null;
			temp2 = null;
			
			return true;
		}
		else return false;
	} 
	
	//Métodos de borrado
	public void borrarPrimerNodo(){
		this.topForward = this.topForward.next;
		this.topForward.previous.next = null;
		this.topForward.previous = null;
	}

	public void borrarUltimoNodo(){
		this.topBackward = this.topBackward.previous;
		this.topBackward.next.previous = null;
		this.topBackward.next = null;
	}

	
	//Borrar cualquier nodo que no sea el primero
	public boolean borrarCualquierNodo(String buscado){
		Node temp = this.topForward;

		while ( (temp != null) 
				&& temp.name.equals(buscado) == false ) {	
		         temp = temp.next;
		}

		if (temp != null){  //Nodo buscado se encontró
			temp.next = temp.next.next;
			temp.next.previous.previous = null;
			temp.next.previous.next = null;
			temp.next.previous = temp;
			temp = null;
			
			return true;
		}
		else return false;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    public Node buscarPorPosicion(int posicion) {
    if (posicion < 1) {
        System.out.println("Posición no válida. La posición debe ser mayor o igual a 1.");
        return null;
    }

    int contador = 0;
    Node temp = this.topForward;

    while (temp != null && contador < posicion) {
        temp = temp.next;
        contador++;
    }

    if (temp == null) {
        System.out.println("No se encontró un nodo en la posición especificada.");
        return null;
    } else {
        return temp;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void insertaNodoAntesUltimo(String nombre) {
    if (topBackward == null) {
        System.out.println("La lista está vacía. No se puede insertar antes del último.");
        return;
    }

    Node temp = new Node();
    temp.name = nombre;

    if (topBackward.previous == null) {
        // Solo hay un nodo en la lista
        temp.next = topBackward;
        temp.previous = null;
        topForward = temp;
        topBackward.previous = temp;
    } else {
        temp.next = topBackward;
        temp.previous = topBackward.previous;
        topBackward.previous.next = temp;
        topBackward.previous = temp;
    }
}
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean intercambiarNodos(String nodoBuscado1, String nodoBuscado2) {
    Node temp1 = buscarNodoPorNombre(nodoBuscado1);
    Node temp2 = buscarNodoPorNombre(nodoBuscado2);

    if (temp1 != null && temp2 != null) {
        // Intercambiar los nodos
        Node temp1Prev = temp1.previous;
        Node temp1Next = temp1.next;

        Node temp2Prev = temp2.previous;
        Node temp2Next = temp2.next;

        // Actualizar nodos adyacentes al primer nodo
        if (temp1Prev != null) {
            temp1Prev.next = temp2;
        } else {
            topForward = temp2;
        }

        if (temp1Next != null) {
            temp1Next.previous = temp2;
        } else {
            topBackward = temp2;
        }

        // Actualizar nodos adyacentes al segundo nodo
        if (temp2Prev != null) {
            temp2Prev.next = temp1;
        } else {
            topForward = temp1;
        }

        if (temp2Next != null) {
            temp2Next.previous = temp1;
        } else {
            topBackward = temp1;
        }

        // Intercambiar los nodos en sí
        temp1.previous = temp2Prev;
        temp1.next = temp2Next;

        temp2.previous = temp1Prev;
        temp2.next = temp1Next;

        return true;
    } else {
        System.out.println("Uno o ambos nodos buscados no se encontraron.");
        return false;
    }
}

private Node buscarNodoPorNombre(String nombre) {
    Node temp = topForward;

    while (temp != null && !temp.name.equals(nombre)) {
        temp = temp.next;
    }

    return temp;
}

}
