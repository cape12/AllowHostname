package io.github.cape12.AllowHostname;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public class AllowHostname extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        List<String> AllowedHostname = getConfig().getStringList("allow-hostname");
        getLogger().info("허용된 서버 주소: " + Arrays.toString(AllowedHostname.toArray()));

        // 이벤트 리스너 등록
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("플러그인 활성화됨!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent e) {

        List<String> AllowedHostname = getConfig().getStringList("allow-hostname");
        boolean outputlog = getConfig().getBoolean("output-log");

        String playerName = e.getPlayer().getName();
        String getaddress = e.getHostname().toLowerCase();

        if (AllowedHostname.contains(getaddress)) {
            if (outputlog) { getLogger().info( "유저 접속 성공 - " + playerName + " (" + getaddress + ")"); }
        } else {
            e.disallow(PlayerLoginEvent.Result.KICK_BANNED,"해당 서버 주소로는 접속이 불가능 합니다.");
            if (outputlog) { getLogger().info( "유저 접속 실패 - " + playerName + " - " + getaddress + " - 금지된 서버 주소 사용"); }
        }
    }
}