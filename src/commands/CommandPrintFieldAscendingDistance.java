package commands;

import connection.client.Client;
import logic.Packet;
import logic.User;
import connection.server.Server;


public class CommandPrintFieldAscendingDistance extends Command {

    public CommandPrintFieldAscendingDistance() {
        super(true);
    }

    public boolean getRequireLogin() {
        return require_login;
    }

    @Override
    public Packet execOnClient(Client client, String ... args) {
        if (client.getUser().getLoginState()) {
            return new Packet(this, args, client.getUser());
        } else {
            System.err.println("You must login!");
            return null;
        }
    }

    @Override
    public String execOnServer(Server server, Object args, User user) {
        return server.getManager().print_field_ascending_distance();
    }
}
