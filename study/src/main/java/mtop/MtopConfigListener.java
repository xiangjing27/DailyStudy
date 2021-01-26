package mtop;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangjing
 * @version : MtopConfigListener, v 0.1 2020-11-21 10:24 xiangjing Exp$
 */
public class MtopConfigListener extends AnalysisEventListener<MtopConfigData> {

    List<MtopConfigData> list = new ArrayList<MtopConfigData>();

    public void invoke(MtopConfigData data, AnalysisContext context) {
        //LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        //if (list.size() >= BATCH_COUNT) {
        //    saveData();
        //    // 存储完成清理 list
        //    list.clear();
        //}
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        //saveData();
        //LOGGER.info("所有数据解析完成！");
    }

    public List<MtopConfigData> getList() {
        return list;
    }
}
