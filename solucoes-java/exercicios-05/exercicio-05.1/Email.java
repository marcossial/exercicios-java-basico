public record Email() implements Message {
    @Override
    public void send(String msg) {
        System.out.println("Você enviou por E-mail a mensagem: " + msg);
    }
}
