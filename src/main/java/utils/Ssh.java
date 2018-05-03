package utils;

import com.jcraft.jsch.*;

public class Ssh {
    /**
     * @param login
     * @param url
     * @param pass
     * @param srcFile
     * @param destFile
     * @throws JSchException
     */
    public static void getTestData(String login, String url, String pass, String srcFile, String destFile) throws JSchException {
        try {
            JSch ssh = new JSch();
            Session session = ssh.getSession(login, url, 22);

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(pass);

            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();

            ChannelSftp sftp = (ChannelSftp) channel;

            //sftp.cd("templates/scenario.json");
            sftp.get(srcFile, destFile);

            Boolean success = true;

            if (success) {
                // The file has been succesfully downloaded
            }

            channel.disconnect();
            session.disconnect();
        } catch (JSchException e) {
            System.out.println(e.getMessage().toString());
            e.printStackTrace();
        } catch (SftpException e) {
            System.out.println(e.getMessage().toString());
            e.printStackTrace();
        }
    }
}
