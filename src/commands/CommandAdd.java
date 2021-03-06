package commands;

import connection.client.Client;
import logic.Packet;
import logic.collectionClasses.Route;
import logic.User;
import connection.server.Server;


public class CommandAdd extends Command {

    public CommandAdd() {
        super(true);
    }

    public boolean getRequireLogin() {
        return require_login;
    }

    public String execOnServer(Server server, Object object, User user) {
        return server.getManager().add(server, (Route) object, user);
    }

    @Override
    public Packet execOnClient(Client client, String ... args) {
        if (client.getUser().getLoginState()) {
            Route route = Route.generateObjectUserInput(client.getUser());
            return new Packet(this, route, client.getUser());
        } else {
            System.err.println("You must login!");
            return null;
        }
    }
}
