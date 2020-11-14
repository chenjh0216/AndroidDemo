package com.jyh.androiddemo.net.apis.wx;

import com.jyh.androiddemo.entity.wx.AccessTokenEntity;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WxApis {

    public static final String baseWxUrl = "https://api.weixin.qq.com/";

    /**
     * 获取access token
     */
    public static final String GetAccessToken = "cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    @GET("cgi-bin/token")
    Observable<AccessTokenEntity> token(@Query("grant_type") String grantType ,@Query("appid") String appId,@Query("secret") String secret);

    /**
     * 调用云函数
     */
    public static final String InvokeCloudFunction = "/tcb/invokecloudfunction?access_token=ACCESS_TOKEN&env=ENV&name=FUNCTION_NAME";

    /**
     * 导入
     */
    public static final String DatabaseMigrateImport = "/tcb/databasemigrateimport?access_token=ACCESS_TOKEN";

    /**
     * 导出
     */
    public static final String DatabaseMigrateExport = "/tcb/databasemigrateexport?access_token=ACCESS_TOKEN";

    /**
     * 迁移状态查询
     */
    public static final String DatabaseMigrateQueryInfo = "/tcb/databasemigratequeryinfo?access_token=ACCESS_TOKEN";

    /**
     * 聚合
     */
    public static final String DatabaseAggregate = "/tcb/databaseaggregate?access_token=ACCESS_TOKEN";

    /**
     * 统计记录数量
     */
    public static final String DatabaseCount = "/tcb/databasecount?access_token=ACCESS_TOKEN";

    /**
     * 添加集合
     */
    public static final String DatabaseCollectionAdd = "/tcb/databasecollectionadd?access_token=ACCESS_TOKEN";

    /**
     * 删除集合
     */
    public static final String DatabaseCollectionDelete = "/tcb/databasecollectiondelete?access_token=ACCESS_TOKEN";

    /**
     * 获取集合信息
     */
    public static final String DatabaseCollectionGet = "/tcb/databasecollectionget?access_token=ACCESS_TOKEN";

    /**
     * 添加记录
     */
    public static final String DatabaseAdd = "/tcb/databaseadd?access_token=ACCESS_TOKEN";

    /**
     * 删除记录
     */
    public static final String DatabaseDelete = "/tcb/databasedelete?access_token=ACCESS_TOKEN";

    /**
     * 更新记录
     */
    public static final String DatabaseUpdate = "/tcb/databaseupdate?access_token=ACCESS_TOKEN";

    /**
     * 查询记录
     */
    public static final String DatabaseQuery = "/tcb/databasequery?access_token=ACCESS_TOKEN";

    /**
     * 获取文件上传链接
     */
    public static final String UploadFile = "/tcb/uploadfile?access_token=ACCESS_TOKEN";

    /**
     * 获取下载链接
     */
    public static final String BatchDownloadFile = "/tcb/batchdownloadfile?access_token=ACCESS_TOKEN";

    /**
     * 删除文件
     */
    public static final String BatchDeleteFile = "/tcb/batchdeletefile?access_token=ACCESS_TOKEN";

    /**
     * 获取腾讯云调用凭证
     */
    public static final String GetQcloudToken = "/tcb/getqcloudtoken?access_token=ACCESS_TOKEN";

}
