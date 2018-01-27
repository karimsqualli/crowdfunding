package org.mql.gc.actions;

import org.mql.gc.models.Case;

public class DetailCase {
	private Case caseObject;
	private String association;
	
		public DetailCase() {}

		public Case getCaseObject() {
			return caseObject;
		}

		public void setCaseObject(Case caseObject) {
			this.caseObject = caseObject;
		}

		public String getAssociation() {
			return association;
		}

		public void setAssociation(String association) {
			this.association = association;
		}
	
		
}


