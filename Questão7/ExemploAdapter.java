package Questão7;

/*O padrão Adapter deve ser preferido em situações específicas onde é necessário integrar ou
 compatibilizar classes com interfaces incompatíveis entre si, permitindo que elas trabalhem juntas
 sem modificar suas implementações originais. Ele é particularmente útil quando se quer adaptar
 uma classe existente para ser usada em um novo contexto ou quando se deseja reutilizar código
 existente sem modificá-lo diretamente.
 */

 //Interface que o usuario pretende utilizar
 interface Retangulo {
    void desenharRetangulo();
}

//Classe que desenha um quadrado 
class Quadrado {
    public void desenharQuadrado() {
        System.out.println("Desenhando um quadrado...");
    }
}

//Adapter que adapta e converte a interface de quadrado para retangulo
class AdaptadorQuadradoParaRetangulo implements Retangulo {
    private Quadrado quadrado;

    public AdaptadorQuadradoParaRetangulo(Quadrado quadrado) {
        this.quadrado = quadrado;
    }

    @Override
    public void desenharRetangulo() {
        quadrado.desenharQuadrado();
    }
}

//Cliente usando o Adapter
class Cliente {
    public void desenharForma(Retangulo retangulo) {
        retangulo.desenharRetangulo();
    }
}

//Testando o Adapter
public class ExemploAdapter {
    public static void main(String[] args) {
        Quadrado quadrado = new Quadrado();
        Retangulo adaptador = new AdaptadorQuadradoParaRetangulo(quadrado);
        Cliente cliente = new Cliente();
        cliente.desenharForma(adaptador);
    }
}
