public record WhatsApp() implements Message {
    @Override
    public void send(String msg) {
        System.out.println("Você enviou por WhatsApp a mensagem: " + msg);
    }
}
