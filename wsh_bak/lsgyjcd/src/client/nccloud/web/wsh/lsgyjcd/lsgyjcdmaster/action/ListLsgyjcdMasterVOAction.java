package nccloud.web.wsh.lsgyjcd.lsgyjcdmaster.action;

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
import nc.itf.wsh.lsgyjcd.lsgyjcdmaster.ILsgyjcdMasterVOService;
import nc.vo.lsgyjcd.lsgyjcd.LsgyjcdMasterVO;
/**
 * �б��ѯ
 */
public class ListLsgyjcdMasterVOAction extends BaseAction{

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

		ILsgyjcdMasterVOService service = ServiceLocator.find(ILsgyjcdMasterVOService.class);
		//��ѯ��ǰ���������е�����pk
		String[] allpks = service.listLsgyjcdMasterVOPkByCond(searchSql);
		if(ArrayUtils.isEmpty(allpks)){
			return null;
		}
		//pk����
		//Arrays.sort(allpks);
		param.setAllpks(allpks);
		//���ݷ�ҳ�õ���ǰ��ҳ��pk
		String[] curPagePks = pageInfo == null ? allpks : paramWapper.pageResult(pageInfo, allpks);
		LsgyjcdMasterVO[] vos =  service.listLsgyjcdMasterVOByPk(curPagePks);
		//���췵�ؽ��
		return buildResult(param,false,null,vos);
	}
	
}