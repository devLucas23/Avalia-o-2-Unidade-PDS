/*Alternativa B: Sim, o padrão Composite ainda pode ser usado mesmo se a maioria dos objetos
forem folhas e apenas alguns tiverem filhos. O padrão é flexível o suficiente para lidar com
diferentes proporções de folhas e compostos.

Mesmo que haja poucos objetos compostos e muitos objetos folha, o padrão Composite ainda
oferece benefícios. A ideia é que, ao tratar folhas e compostos de forma uniforme, 
o sistema permanece simples e extensível. No entanto, dependendo do uso e da performance
desejada, pode ser interessante otimizar a estrutura. Uma implementação para esse cenário 
seria semelhante à anterior, onde a maioria dos objetos seriam folhas sem filhos, 
mas ainda seria possível adicionar objetos compostos quando necessário. */

package Questão8;

import java.util.ArrayList;
import java.util.List;

// Aqui é a Interface comum
interface Component {
    void operation();
}

// Objeto folha
class Leaf implements Component {
    public void operation() {
        System.out.println("Operação de uma folha");
    }
}

// Objeto composto que pode conter outros Componentes
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void operation() {
        for (Component child : children) {
            child.operation();
        }
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }
}

// Aqui esta em uso do padrão 
public class Client {
    public static void main(String[] args) {
        // Criação das folhas
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();

        // Cria um composto e adiciona folhas a ele
        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);

        // O cliente chama a operação independentemente de ser folha ou composto
        composite.operation();
    }
}

