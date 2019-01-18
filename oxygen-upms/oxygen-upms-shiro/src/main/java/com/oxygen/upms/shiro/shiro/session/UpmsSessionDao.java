package com.oxygen.upms.shiro.shiro.session;

import com.oxygen.common.util.RedisUtil;
import com.oxygen.upms.shiro.util.SerializableUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by yangxy on 2017/9/8.
 */
public class UpmsSessionDao extends CachingSessionDAO {
    private static Logger _log = LoggerFactory.getLogger(UpmsSessionDao.class);
    // 会话key
    private final static String _UPMS_SHIRO_SESSION_ID = "oxygen-upms-shiro-session-id";
    // 全局会话key
    private final static String _UPMS_SERVER_SESSION_ID = "oxygen-upms-server-session-id";
    // 全局会话列表key
    private final static String _UPMS_SERVER_SESSION_IDS = "oxygen-upms-server-session-ids";
    // code key
    private final static String _UPMS_SERVER_CODE = "oxygen-upms-server-code";
    // 局部会话key
    private final static String _UPMS_CLIENT_SESSION_ID = "oxygen-upms-client-session-id";
    // 单点同一个code所有局部会话key
    private final static String _UPMS_CLIENT_SESSION_IDS = "oxygen-upms-client-session-ids";

    @Override
    protected void doUpdate(Session session) {
        _log.debug("doUpdate >>>>> sessionId={}", session.getId());
    }

    @Override
    protected void doDelete(Session session) {
        String sessionId = session.getId().toString();
        _log.debug("doUpdate >>>>> sessionId={}", sessionId);
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        RedisUtil.set(_UPMS_SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
        _log.debug("doCreate >>>>> sessionId={}", sessionId);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        String session = RedisUtil.get(_UPMS_SHIRO_SESSION_ID + "_" + sessionId);
        _log.debug("doReadSession >>>>> sessionId={}", sessionId);
        return SerializableUtil.deserialize(session);
    }


    /**
     * 更改在线状态
     *
     * @param sessionId
     * @param onlineStatus
     */
    public void updateStatus(Serializable sessionId, UpmsSession.OnlineStatus onlineStatus) {
        UpmsSession session = (UpmsSession) doReadSession(sessionId);
        if (null == session) {
            return;
        }
        session.setStatus(onlineStatus);
        RedisUtil.set(_UPMS_SHIRO_SESSION_ID + "_" + session.getId(), SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
    }
}
