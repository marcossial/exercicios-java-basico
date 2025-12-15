public record Sms() implements Message {
    @Override
    public void send(String msg) {
        System.out.println("Você enviou por SMS a mensagem: " + msg);
    }
}
