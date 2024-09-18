package juan.co.edu.uptc.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class ElectricVehicle {
    public Meta meta;
    public ArrayList<ArrayList<Object>> data;
}
@Setter
@Getter
class  Approval{
    public int reviewedAt;
    public boolean reviewedAutomatically;
    public String state;
    public int submissionId;
    public String submissionObject;
    public String submissionOutcome;
    public int submittedAt;
    public String targetAudience;
    public int workflowId;
    public SubmissionDetails submissionDetails;
    public SubmissionOutcomeApplication submissionOutcomeApplication;
    public Submitter submitter;
}

@Setter
@Getter
class ClientContext{
    public ArrayList<Object> clientContextVariables;
    public InheritedVariables inheritedVariables;
}

@Setter
@Getter
class Column{
    public int id;
    public String name;
    public String dataTypeName;
    public String fieldName;
    public int position;
    public String renderTypeName;
    public Format format;
    public ArrayList<String> flags;
    public String description;
    public int tableColumnId;
    public ComputationStrategy computationStrategy;
}

@Setter
@Getter
class ComputationStrategy{
    public ArrayList<String> source_columns;
    public String type;
    public Parameters parameters;
}

@Setter
@Getter
class CustomFields{
    @JsonProperty("Temporal")
    public Temporal temporal;
    @JsonProperty("Identification")
    public Identification identification;
    @JsonProperty("Notes")
    public Notes notes;
}

@Setter
@Getter
class Format{
    public String align;
}

@Setter
@Getter
class Grant{
    public boolean inherited;
    public String type;
    public ArrayList<String> flags;
}

@Setter
@Getter
class Identification{
    @JsonProperty("Originator")
    public String originator;
    @JsonProperty("Metadata Language")
    public String metadataLanguage;
}

@Setter
@Getter
class InheritedVariables{
}

@Setter
@Getter
class License{
    public String name;
    public String termsLink;
}

@Setter
@Getter
class Meta{
    public View view;
}

@Setter
@Getter
class Metadata{
    public CustomFields custom_fields;
    public String rowLabel;
    public ArrayList<String> availableDisplayTypes;
}

@Setter
@Getter
class Notes{
    @JsonProperty("1. ")
    public String _1;
    @JsonProperty("2. ")
    public String _2;
    @JsonProperty("3. ")
    public String _3;
    @JsonProperty("4. ")
    public String _4;
}

@Setter
@Getter
class Owner{
    public String id;
    public String displayName;
    public String profileImageUrlLarge;
    public String profileImageUrlMedium;
    public String profileImageUrlSmall;
    public String screenName;
    public String type;
    public ArrayList<String> flags;
}

@Setter
@Getter
class Parameters{
    public String region;
    public String primary_key;
}

@Setter
@Getter
class Query{
}


@Setter
@Getter
class SubmissionDetails{
    public String permissionType;
}

@Setter
@Getter
class SubmissionOutcomeApplication{
    public int failureCount;
    public String status;
}

@Setter
@Getter
class Submitter{
    public String id;
    public String displayName;
}

@Setter
@Getter
class TableAuthor{
    public String id;
    public String displayName;
    public String profileImageUrlLarge;
    public String profileImageUrlMedium;
    public String profileImageUrlSmall;
    public String screenName;
    public String type;
    public ArrayList<String> flags;
}

@Setter
@Getter
class Temporal{
    @JsonProperty("Posting Frequency")
    public String postingFrequency;
    @JsonProperty("Period of Time")
    public String periodofTime;
}

@Setter
@Getter
class View{
    public String id;
    public String name;
    public String assetType;
    public String attribution;
    public int averageRating;
    public String category;
    public int createdAt;
    public String description;
    public String displayType;
    public int downloadCount;
    public boolean hideFromCatalog;
    public boolean hideFromDataJson;
    public String licenseId;
    public boolean locked;
    public boolean newBackend;
    public int numberOfComments;
    public int oid;
    public String provenance;
    public boolean publicationAppendEnabled;
    public int publicationDate;
    public int publicationGroup;
    public String publicationStage;
    public int rowsUpdatedAt;
    public String rowsUpdatedBy;
    public int tableId;
    public int totalTimesRated;
    public int viewCount;
    public int viewLastModified;
    public String viewType;
    public ArrayList<Approval> approvals;
    public ClientContext clientContext;
    public ArrayList<Column> columns;
    public ArrayList<Grant> grants;
    public License license;
    public Metadata metadata;
    public Owner owner;
    public Query query;
    public ArrayList<String> rights;
    public TableAuthor tableAuthor;
    public ArrayList<String> tags;
    public ArrayList<String> flags;
}