// Classe que representa um nó da lista encadeada
class Node {
    int data;
    Node next;

    // Construtor para inicializar um nó com um valor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Classe que implementa a lista encadeada
class LinkedList {
    private Node head;

    // Método para adicionar um elemento ao final da lista
    public void append(int data) {
        Node newNode = new Node(data); // Cria um nó com o valor fornecido

        // Se a lista estiver vazia, o novo nó se torna o primeiro nó (head)
        if (head == null) {
            head = newNode;
            System.out.println("Valor " + data + " adicionado à lista.");
            return;
        }

        // Percorre a lista até o último nó
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Valor " + data + " adicionado à lista.");
    }

    // Método para exibir os elementos da lista
    public void display() {
        if (head == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        // Percorre a lista e exibe os valores armazenados
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null"); // Indica o final da lista
    }

    // Método para remover um elemento da lista
    public void delete(int data) {
        if (head == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        // Caso o elemento a ser removido esteja no primeiro nó (head)
        if (head.data == data) {
            head = head.next; // Atualiza o head para o próximo nó
            System.out.println("Elemento " + data + " removido com sucesso.");
            return;
        }

        // Percorre a lista para encontrar o nó com o valor a ser removido
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        // Caso o valor não tenha sido encontrado
        if (current.next == null) {
            System.out.println("Valor " + data + " não encontrado na lista.");
        } else {
            // Remove o nó ao ajustar a referência para o próximo nó
            current.next = current.next.next;
            System.out.println("Elemento " + data + " removido com sucesso.");

        }
    }
}

// Classe principal para testar a implementação da lista encadeada
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adiciona elementos à lista
        list.append(10);
        list.append(15);
        list.append(20);
        list.append(22);
        list.append(30);
        list.append(45);
        list.append(50);
        list.append(75);

        // Exibe a lista atual
        System.out.println("\nLista atual: ");
        list.display();

        // Remove alguns elementos da lista
        System.out.println("\nRemovendo os elementos...");
        list.delete(20);
        list.delete(22);

        // Exibe a lista após as remoções
        System.out.println("\nLista após remoção: ");
        list.display();
    }
}
