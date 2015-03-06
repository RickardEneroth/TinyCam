package se.eneroth.tinycam;

public class NameAndUrl {
		private String name;
		private String url;

		public NameAndUrl(String name, String url) {
			this.name = name;
			this.url = url;
		}

		public String getName() {
			return name;
		}

		public String getUrl() {
			return url;
		}
		
		public String getFixedUrl() {
			return url.replace('_', '-');
		}
}
