package nccloud.web.wsh.wxrk.wxrkmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.wxrk.wxrk.AggWxrkMasterVO;
import nc.itf.wsh.wxrk.wxrkmaster.IWxrkMasterVOService;

/**
 * �༭Action
 */
public class EditWxrkMasterVOAction extends BaseAction{
	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		String pk = param.getPk();
		
		IWxrkMasterVOService service = ServiceLocator.find(IWxrkMasterVOService.class);
		
		AggWxrkMasterVO vo = service.preEditAggWxrkMasterVO(pk);
		
		if(vo == null){
			return null;
		}
		return buildResult(param,true,null,vo);
	}
	
}