package nccloud.web.wsh.gxth.gxthmaster.action;

import java.util.Arrays;
import java.util.Collections;

import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;

import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;

import nccloud.pubitf.platform.query.INCCloudQueryService;
import nccloud.dto.baseapp.querytree.dataformat.QueryTreeFormatVO;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nccloud.commons.lang.StringUtils;
import nccloud.commons.lang.ArrayUtils;
import nccloud.framework.web.ui.model.PageInfo;
import nc.itf.wsh.gxth.gxthmaster.IGxthMasterVOService;
import nc.vo.gxth.gxth.GxthMasterVO;
/**
 * �б���ѯ
 */
public class ListGxthMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		PageInfo pageInfo = param.getPageInfo();
		
		//��ѯ����
		INCCloudQueryService nccloudService = ServiceLocator.find(INCCloudQueryService.class);
		QueryTreeFormatVO queryVo = param.getQueryTreeFormatVO();
		String searchSql = "";
		if(queryVo != null){
			IQueryScheme searchService = nccloudService.convertCondition(queryVo);
			searchSql = searchService.getWhereSQLOnly();
		}

		IGxthMasterVOService service = ServiceLocator.find(IGxthMasterVOService.class);
		//��ѯ��ǰ���������е�����pk
		String[] allpks = service.listGxthMasterVOPkByCond(searchSql);
		if(ArrayUtils.isEmpty(allpks)){
			return null;
		}
		//pk����
		//Arrays.sort(allpks);
		param.setAllpks(allpks);
		//���ݷ�ҳ�õ���ǰ��ҳ��pk
		String[] curPagePks = pageInfo == null ? allpks : paramWapper.pageResult(pageInfo, allpks);
		GxthMasterVO[] vos =  service.listGxthMasterVOByPk(curPagePks);
		//���췵�ؽ��
		return buildResult(param,false,null,vos);
	}
	
}