package nabed.apps.nabedutilslibrary.data.db.prescriptions

import androidx.room.ColumnInfo


data class PrescriptionEntity (
    @ColumnInfo(name = "id")
    override val id: Int,
//    @ColumnInfo(name = "media")
//    override val media: List<Media>,
//    @ColumnInfo(name = "parent_id")
//    override val parentId: Int,
    @ColumnInfo(name = "title")
    override val title: String
//    @ColumnInfo(name = "videos")
//    override val videos: List<Video>

) : UnitSpecificPrescriptionsItem
