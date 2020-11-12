package com.jyh.androiddemo.net.apis;

public class WxApis {

    /**
     * 获取access token
     */
    private static final String GetAccessToken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 调用云函数
     */
    private static final String InvokeCloudFunction = "https://api.weixin.qq.com/tcb/invokecloudfunction?access_token=ACCESS_TOKEN&env=ENV&name=FUNCTION_NAME";

    /**
     * 导入
     */
    private static final String DatabaseMigrateImport = "https://api.weixin.qq.com/tcb/databasemigrateimport?access_token=ACCESS_TOKEN";

    /**
     * 导出
     */
    private static final String DatabaseMigrateExport = "https://api.weixin.qq.com/tcb/databasemigrateexport?access_token=ACCESS_TOKEN";

    /**
     * 迁移状态查询
     */
    private static final String DatabaseMigrateQueryInfo = "https://api.weixin.qq.com/tcb/databasemigratequeryinfo?access_token=ACCESS_TOKEN";

    /**
     * 聚合
     */
    private static final String DatabaseAggregate = "https://api.weixin.qq.com/tcb/databaseaggregate?access_token=ACCESS_TOKEN";

    /**
     * 统计记录数量
     */
    private static final String DatabaseCount = "https://api.weixin.qq.com/tcb/databasecount?access_token=ACCESS_TOKEN";

    /**
     * 添加集合
     */
    private static final String DatabaseCollectionAdd = "https://api.weixin.qq.com/tcb/databasecollectionadd?access_token=ACCESS_TOKEN";

    /**
     * 删除集合
     */
    private static final String DatabaseCollectionDelete = "https://api.weixin.qq.com/tcb/databasecollectiondelete?access_token=ACCESS_TOKEN";

    /**
     * 获取集合信息
     */
    private static final String DatabaseCollectionGet = "https://api.weixin.qq.com/tcb/databasecollectionget?access_token=ACCESS_TOKEN";

    /**
     * 添加记录
     */
    private static final String DatabaseAdd = "https://api.weixin.qq.com/tcb/databaseadd?access_token=ACCESS_TOKEN";

    /**
     * 删除记录
     */
    private static final String DatabaseDelete = "https://api.weixin.qq.com/tcb/databasedelete?access_token=ACCESS_TOKEN";

    /**
     * 更新记录
     */
    private static final String DatabaseUpdate = "https://api.weixin.qq.com/tcb/databaseupdate?access_token=ACCESS_TOKEN";

    /**
     * 查询记录
     */
    private static final String DatabaseQuery = "https://api.weixin.qq.com/tcb/databasequery?access_token=ACCESS_TOKEN";

    /**
     * 获取文件上传链接
     */
    private static final String UploadFile = "https://api.weixin.qq.com/tcb/uploadfile?access_token=ACCESS_TOKEN";

    /**
     * 获取下载链接
     */
    private static final String BatchDownloadFile = "https://api.weixin.qq.com/tcb/batchdownloadfile?access_token=ACCESS_TOKEN";

    /**
     * 删除文件
     */
    private static final String BatchDeleteFile = "https://api.weixin.qq.com/tcb/batchdeletefile?access_token=ACCESS_TOKEN";

    /**
     * 获取腾讯云调用凭证
     */
    private static final String GetQcloudToken = "https://api.weixin.qq.com/tcb/getqcloudtoken?access_token=ACCESS_TOKEN";

}
