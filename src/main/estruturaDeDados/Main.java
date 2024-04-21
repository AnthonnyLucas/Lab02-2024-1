package estruturaDeDados;
public class Main {
    public static void main(String[] args) {
        Lista lista = EstruradeDadosBuild.buildLista();
        lista.insereElemento(10);
        lista.insereElemento(20);
        lista.insereElemento(30);
        lista.buscaIndice(20);
    }
}
