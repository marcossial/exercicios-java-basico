public record SocialMedia() implements Message {
    @Override
    public void send(String msg) {
        System.out.println("Você enviou por uma Rede Social a mensagem: " + msg);
    }
}
