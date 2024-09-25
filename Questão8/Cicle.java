/*Alternativa A: O padrão Composite ajuda a consolidar a lógica condicional ao permitir que 
tanto objetos individuais quanto composições de objetos sejam tratados de maneira uniforme. 
O principal benefício é que ele elimina a necessidade de verificar explicitamente se um componente 
é uma folha (um objeto simples) ou um composto (um conjunto de objetos) na maioria dos casos. 
Isso é feito por meio de uma interface ou classe base comum que define operações aplicáveis a 
ambos os tipos de componentes (folhas e compostos).

Sem o Composite: Você precisaria de verificações condicionais frequentes para determinar se 
um componente é uma folha ou um composto. O código teria que se adaptar manualmente ao tipo 
de objeto em cada ponto, criando lógica condicional que aumenta a complexidade do sistema.

Com o Composite: O código cliente pode operar com a interface ou classe base comum sem se 
preocupar com o tipo específico do objeto (se é folha ou composto). Isso simplifica a lógica 
do cliente e melhora a extensibilidade, pois novos tipos de folhas ou composições podem ser 
adicionados sem modificar o código existente que utiliza o padrão Composite. */

package Questão8;

import java.util.ArrayList;
import java.util.List;

interface Graphic {
    void draw();
}

class Circle implements Graphic {
    public void draw() {
        // Implementação do desenho de um círculo
    }
}

class CompositeGraphic implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void draw() {
        // Desenha todos os gráficos filhos
        for (Graphic graphic : children) {
            graphic.draw();
        }
    }

    public void add(Graphic graphic) {
        children.add(graphic);
    }

    public void remove(Graphic graphic) {
        children.remove(graphic);
    }
}

