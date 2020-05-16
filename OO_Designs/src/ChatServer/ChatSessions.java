package ChatServer;

import java.util.HashSet;

public class ChatSessions {
	HashSet<chatSession> activeSessions;

	public ChatSessions() {
		activeSessions = new HashSet<>();
	}

	static class chatSession {
		Client client1;
		Client client2;

		public chatSession(Client client1, Client client2) {
			super();
			this.client1 = client1;
			this.client2 = client2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((client1 == null) ? 0 : client1.hashCode());
			result = prime * result + ((client2 == null) ? 0 : client2.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			chatSession other = (chatSession) obj;
			if (client1 == null) {
				if (other.client1 != null)
					return false;
			} else if (!client1.equals(other.client1))
				return false;
			if (client2 == null) {
				if (other.client2 != null)
					return false;
			} else if (!client2.equals(other.client2))
				return false;
			return true;
		}

	}

	void addSession(Client c1, Client c2) {
		chatSession s = new chatSession(c1, c2);
	}

	void logoutSession(chatSession ses) {
		activeSessions.remove(ses);
	}
}
