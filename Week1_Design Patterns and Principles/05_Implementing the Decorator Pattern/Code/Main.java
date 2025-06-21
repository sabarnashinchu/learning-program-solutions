public class Main {
    public static void main(String[] args) {
        Notifier email = new EmailNotifier();
        Notifier smsEmail = new SMSNotifierDecorator(email);
        Notifier slackSmsEmail = new SlackNotifierDecorator(smsEmail);
        slackSmsEmail.send("System Update at 9 PM");
    }
}
