package caixaeletronico;
import java.util.Scanner;

//@author Ana Coutinho

public class Caixaeletronico {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bem Vindo!\nPressione Enter para prosseguir.");
        input.nextLine();
        inicio();
        while(true)
        {
            menu();
        }
    }
    static void inicio()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira seu CPF: ");
        int aux = input.nextInt();
        while(aux != globais.cpf)
        {
            System.out.println("CPF inválido, insira novamente");
            System.out.print("CPF: ");
            aux = input.nextInt();
        }
        System.out.print("Insira sua senha: ");
        int auxs = input.nextInt();
        while(auxs != globais.senha)
        {
            System.out.println("Senha inválida, insira novamente");
            System.out.print("Senha: ");
            auxs = input.nextInt();
        }
    }
    
    static void menu()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEscolha sua opção:");
        System.out.println("1 - Consulta de Saldo\t2 - Depósito\n3 - Saque\t\t0 - Sair");
        System.out.print("Opção: ");
        int op = input.nextInt();
        switch(op)
        {
            case 1:
                saldo();
            break;            
            
            case 2:
                deposito();
            break;            
            
            case 3:
                saque();
            break;
            
            case 0:
                System.out.println("\nObrigada por usar nossos serviços!");
                System.exit(0);
            break;
            
            default:
                System.out.println("Opção inválida");
            break;
        }
    }
    
    static void saldo()
    {
        System.out.println("Saldo atual = R$"+globais.saldo);
        conf();
    }
    
    static void deposito()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o valor do depósito: ");
        float dep = input.nextFloat();
        globais.saldo+=dep;
        conf();
    }
    
    static void saque()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor do saque: ");
        System.out.println("Notas disponíveis: \nR$20\tR$50");
        System.out.println("Limite disponível para saque = R$"+globais.saldo);
        System.out.print("Valor: ");
        int saque = input.nextInt();
        if(globais.saldo - saque < 0)
            System.out.println("Valor indisponível para saque.\nSaldo atual inválido");
        else
            globais.saldo-=saque;
        conf();
    }
    
    static void conf()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\nDeseja continuar?\n 1-SIM\t2-NÃO");
        System.out.print("Opção: ");
        int op = input.nextInt();
        if(op==2)
        {
            System.out.println("\nObrigada por usar nossos serviços!");
            System.exit(0);
        }
    }
    
}