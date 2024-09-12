package juan.co.edu.uptc.pojos;
import com.fasterxml.jackson.annotation.JsonProperty;

 import java.util.List;


public class ElectricVehicles {

    public class Approval{
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

    public class ClientContext{
        public List<Object> clientContextVariables;
        public InheritedVariables inheritedVariables;
    }

    public class Column{
        public int id;
        public String name;
        public String dataTypeName;
        public String fieldName;
        public int position;
        public String renderTypeName;
        public Format format;
        public List<String> flags;
        public String description;
        public int tableColumnId;
        public ComputationStrategy computationStrategy;
    }

    public class ComputationStrategy{
        public List<String> source_columns;
        public String type;
        public Parameters parameters;
    }

    public class CustomFields{
        @JsonProperty("Temporal")
        public Temporal temporal;
        @JsonProperty("Identification")
        public Identification identification;
        @JsonProperty("Notes")
        public Notes notes;
    }

    public class Format{
        public String align;
    }

    public class Grant{
        public boolean inherited;
        public String type;
        public List<String> flags;
    }

    public class Identification{
        @JsonProperty("Originator")
        public String originator;
        @JsonProperty("Metadata Language")
        public String metadataLanguage;
    }

    public class InheritedVariables{
    }

    public class License{
        public String name;
        public String termsLink;
    }

    public class Meta{
        public View view;
    }

    public class Metadata{
        public CustomFields custom_fields;
        public String rowLabel;
        public List<String> availableDisplayTypes;
    }

    public class Notes {
        @JsonProperty("1. ")
        public String note1;
        @JsonProperty("2. ")
        public String note2;
        @JsonProperty("3. ")
        public String note3;
        @JsonProperty("4. ")
        public String note4;
    }

    public class Owner{
        public String id;
        public String displayName;
        public String profileImageUrlLarge;
        public String profileImageUrlMedium;
        public String profileImageUrlSmall;
        public String screenName;
        public String type;
        public List<String> flags;
    }

    public class Parameters{
        public String region;
        public String primary_key;
    }

    public class Query{
    }

    public class Root{
        public Meta meta;
        public List<List<Object>> data;
    }

    public class SubmissionDetails{
        public String permissionType;
    }

    public class SubmissionOutcomeApplication{
        public int failureCount;
        public String status;
    }

    public class Submitter{
        public String id;
        public String displayName;
    }

    public class TableAuthor{
        public String id;
        public String displayName;
        public String profileImageUrlLarge;
        public String profileImageUrlMedium;
        public String profileImageUrlSmall;
        public String screenName;
        public String type;
        public List<String> flags;
    }

    public class Temporal{
        @JsonProperty("Posting Frequency")
        public String postingFrequency;
        @JsonProperty("Period of Time")
        public String periodofTime;
    }

    public class View{
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
        public List<Approval> approvals;
        public ClientContext clientContext;
        public List<Column> columns;
        public List<Grant> grants;
        public License license;
        public Metadata metadata;
        public Owner owner;
        public Query query;
        public List<String> rights;
        public TableAuthor tableAuthor;
        public List<String> tags;
        public List<String> flags;
    }
}
