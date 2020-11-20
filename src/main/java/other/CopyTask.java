package other;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingWorker;

public class CopyTask extends SwingWorker<Void, Integer> {
	private String from;
	private String to;

	public CopyTask(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	@Override
	protected Void doInBackground() throws Exception {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {

			in = new FileInputStream(from);
			out = new FileOutputStream(to);

			int bytes = in.available();
			int n = bytes / 100;
			int i = 0;
			byte[] b = new byte[n];

			int len = in.read(b);
			while (len != -1) {
				out.write(b, 0, len);

				publish(len);

				len = in.read(b);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	protected void process(List<Integer> chunks) {
//		System.out.println(chunks);
	}

	@Override
	protected void done() {
		System.out.println("Finished");
	}
}