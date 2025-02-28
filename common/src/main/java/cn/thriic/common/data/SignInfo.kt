package cn.thriic.common.data

import kotlinx.serialization.Serializable

/**
 * @param id 活动签到id
 * @param signInTime 签到时间
 * @param signOutTime 签退时间
 */
@Serializable
data class SignInfo(val id: String, val signInTime: String = "", val signOutTime: String = "")

fun SignInfo.signIn() = this.signInTime.isNotEmpty() && this.signOutTime.isNotEmpty()